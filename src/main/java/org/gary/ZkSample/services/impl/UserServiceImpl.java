package org.gary.ZkSample.services.impl;

import java.util.List;

import org.gary.ZkSample.dao.UserDao;
import org.gary.ZkSample.entity.User;
import org.gary.ZkSample.exception.NoSuchUserException;
import org.gary.ZkSample.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("userServiceImpl")
@Scope(
		value = "singleton", proxyMode = ScopedProxyMode.INTERFACES)
public class UserServiceImpl implements UserService {

	@Autowired private UserDao userDao;

	@Override
	public User addUser(User user) {
		return userDao.save(user);
	}

	@Override
	public void deleteUser(User user) throws NoSuchUserException {
		userDao.delete(user);

	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public List<User> getUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) throws NoSuchUserException {
		return userDao.update(user);
	}

}
