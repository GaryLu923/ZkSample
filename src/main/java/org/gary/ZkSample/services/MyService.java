package org.gary.ZkSample.services;

import org.gary.ZkSample.entity.Log;
import java.util.List;

public interface MyService {

	Log addLog(Log log);

	List<Log> getLogs();

	void deleteLog(Log log);
}
