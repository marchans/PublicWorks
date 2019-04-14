package database.dao.api;

import database.data.users.User;

public interface UsersDao {
	User addUser(User user);

	User getUser(int id);

	void saveUser(User user);
}
