package database.workers;

import org.springframework.beans.factory.annotation.Autowired;

import database.dao.api.UsersDao;
import database.data.users.User;

public class UsersWorker {
	@Autowired
	UsersDao usersDao;
	
	public User addUser(User user) {
		user = usersDao.addUser(user);
		System.out.println(user);
		return user;
	}

}
