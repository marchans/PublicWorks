package database.workers;

import com.google.gson.*;
import database.dao.api.DataBaseWorkerDao;
import database.data.users.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DataBaseWorker {

    @Autowired
    DataBaseWorkerDao dataBaseWorkerDao;

    private EntityManager em;

    public void getAllUsersFromDatabase(){
        dataBaseWorkerDao.getAllUsersFromDatabase();
    }

    public String getAllUsersFromDatabaseGson(){
        return dataBaseWorkerDao.getAllUsersFromDatabaseGson();
    }

    public List<User> getAllUsersFromDatabaseGsonDeserialized(){
        return dataBaseWorkerDao.getAllUsersFromDatabaseGsonDeserialized();
    }

    public String getAllUnverifiedUsersFromDatabaseGson(){
        return dataBaseWorkerDao.getAllUnverifiedUsersFromDatabaseGson();
    }

    public String getAllWorkersFromDatabaseGson(){
        return dataBaseWorkerDao.getAllWorkersFromDatabaseGson();
    }

    public void addNewWorkerToDatabase(JsonObject workerJson){
        dataBaseWorkerDao.addNewWorkerToDatabase(workerJson);
    }
}