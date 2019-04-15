package database.dao.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import database.data.users.User;

import java.util.List;

public interface DataBaseWorkerDao {
    void getAllUsersFromDatabase();

    String getAllUsersFromDatabaseGson();

    List<User> getAllUsersFromDatabaseGsonDeserialized();

    String getAllUnverifiedUsersFromDatabaseGson();

    String getAllWorkersFromDatabaseGson();

    void addNewWorkerToDatabase(JsonObject workerJson);
}