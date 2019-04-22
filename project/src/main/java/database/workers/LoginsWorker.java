package database.workers;

import org.springframework.beans.factory.annotation.Autowired;

import database.dao.api.LoginDao;
import database.data.users.Login;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS)
public class LoginsWorker {
	@Autowired
	LoginDao loginsDao;

	public Login addLogin(Login login) {
		login = loginsDao.addLogin(login);
		System.out.println(login);
		return login;
	}
}
