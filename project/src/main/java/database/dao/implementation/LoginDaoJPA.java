package database.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import database.dao.api.LoginDao;
import database.data.users.Login;

@Repository
@Transactional
public class LoginDaoJPA implements LoginDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Login addLogin(Login login) {
		em.persist(login);
		return login;
	}

	@Override
	public Login getLogin(int id) {
		return em.find(Login.class, id);
	}

	@Override
	public void saveLogin(Login login) {
		em.merge(login);
	}
}
