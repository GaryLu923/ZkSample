package org.gary.ZkSample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.gary.ZkSample.entity.User;
import org.gary.ZkSample.exception.NoSuchUserException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Optional;

@Repository
public class UserDao {
	@PersistenceContext private EntityManager entityManager;

	public void delete(User user) throws NoSuchUserException {
		Optional<User> optionalUser = get(user.getId());
		if (optionalUser.isPresent()) {
			entityManager.remove(optionalUser.get());
		} else {
			throw new NoSuchUserException();
		}

	}

	@Transactional
	public Optional<User> get(Integer id) {
		return Optional.of(entityManager.find(User.class, id));
	}

	@Transactional
	public List<User> getAllUser() {
		Query query = entityManager.createQuery("");
		return query.getResultList();
	}

	@Transactional
	public User save(User user) {
		entityManager.persist(user);
		entityManager.flush();
		return user;
	}

	public User update(User user) throws NoSuchUserException {
		Optional<User> optionalUser = Optional.of(entityManager.find(User.class, user.getId()));
		if (optionalUser.isPresent()) {
			return entityManager.merge(optionalUser.get());
		} else {
			throw new NoSuchUserException();
		}
	}
}
