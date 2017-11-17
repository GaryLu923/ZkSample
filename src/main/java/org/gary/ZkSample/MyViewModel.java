package org.gary.ZkSample;

import java.util.List;

import org.gary.ZkSample.entity.Log;
import org.gary.ZkSample.services.MyService;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.lang.Strings;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class MyViewModel {

	@WireVariable private MyService myService;
	private ListModelList<Log> logListModel;
	private String message;

	@Command
	public void addLog() {
		if (Strings.isBlank(message)) {
			return;
		}
		Log log = new Log(message);
		log = myService.addLog(log);
		logListModel.add(log);
	}

	@Command
	public void deleteLog(@BindingParam("log") Log log) {
		myService.deleteLog(log);
		logListModel.remove(log);
	}

	public ListModel<Log> getLogListModel() {
		return logListModel;
	}

	public String getMessage() {
		return message;
	}

	@Init
	public void init() {
		List<Log> logList = myService.getLogs();
		logListModel = new ListModelList<Log>(logList);
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
