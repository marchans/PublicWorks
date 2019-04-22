package database.workers;

import com.google.gson.*;
import database.dao.api.DataBaseWorkerDao;
import database.data.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Transactional(propagation = Propagation.SUPPORTS)
public class DataBaseWorker {

    @Autowired
    DataBaseWorkerDao dataBaseWorkerDao;

    private EntityManager em;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public void getAllUsersFromDatabase(){
        dataBaseWorkerDao.getAllUsersFromDatabase();
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public String getAllUsersFromDatabaseGson(){
        return dataBaseWorkerDao.getAllUsersFromDatabaseGson();
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<User> getAllUsersFromDatabaseGsonDeserialized(){
        return dataBaseWorkerDao.getAllUsersFromDatabaseGsonDeserialized();
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public String getAllUnverifiedUsersFromDatabaseGson(){
        return dataBaseWorkerDao.getAllUnverifiedUsersFromDatabaseGson();
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public String getAllWorkersFromDatabaseGson(){
        return dataBaseWorkerDao.getAllWorkersFromDatabaseGson();
    }

    public void addNewWorkerToDatabase(JsonObject workerJson){
        dataBaseWorkerDao.addNewWorkerToDatabase(workerJson);
    }
}