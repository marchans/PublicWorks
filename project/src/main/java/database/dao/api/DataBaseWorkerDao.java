package database.dao.api;

import com.google.gson.Gson;
import database.data.users.User;

import java.util.List;

public interface DataBaseWorkerDao {
    void getAllUsersFromDatabase();

    String getAllUsersFromDatabaseGson();

    List<User> getAllUsersFromDatabaseGsonDeserialized();
}
