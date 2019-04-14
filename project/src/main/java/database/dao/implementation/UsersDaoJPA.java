package database.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import database.dao.api.UsersDao;
import database.data.users.User;

@Repository
@Transactional
public class UsersDaoJPA implements UsersDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User addUser(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public User getUser(int id) {
		return em.find(User.class, id);
	}

	@Override
	public void saveUser(User user) {
		em.merge(user);
	}
}
