package org.gary.ZkSample.services.impl;

import java.util.List;

import org.gary.ZkSample.entity.Log;
import org.gary.ZkSample.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("myService")
@Scope(
		value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyServiceImpl implements MyService {

	@Autowired LogDao dao;

	public Log addLog(Log log) {
		return dao.save(log);
	}

	public void deleteLog(Log log) {
		dao.delete(log);
	}

	public List<Log> getLogs() {
		return dao.queryAll();
	}

}
