package database.dao.api;

import database.data.users.Login;;

public interface LoginDao {
	Login addLogin(Login login);

	Login getLogin(int id);

	void saveLogin(Login login);
}
