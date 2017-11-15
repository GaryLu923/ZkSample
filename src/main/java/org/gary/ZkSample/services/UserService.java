package org.gary.ZkSample.services;

import java.util.List;

import org.gary.ZkSample.entity.User;
import org.gary.ZkSample.exception.NoSuchUserException;

public interface UserService {
	User addUser(User user);

	void deleteUser(User user) throws NoSuchUserException;

	List<User> getAllUser();

	List<User> getUserByName(String name);

	User updateUser(User user) throws NoSuchUserException;
}
