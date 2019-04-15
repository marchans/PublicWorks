package database.dao.implementation;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import database.dao.api.DataBaseWorkerDao;
import database.data.roles.workers.Position;
import database.data.roles.workers.ServiceWorker;
import database.data.users.Login;
import database.data.users.User;
import database.workers.PositionsWorker;
import database.workers.ServiceWorkersWorker;
import database.workers.UsersWorker;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Type;
import java.util.List;

@Repository
@Transactional
public class DataBaseWorkerDaoJPA implements DataBaseWorkerDao {

    @PersistenceContext
    private EntityManager em;

    private Gson gson = new Gson();

    @Override
    public void getAllUsersFromDatabase() {
        //List results = em.createQuery("select c from User c").getResultList();

        Query q = em.createQuery("select c from User c");

        List<User> results = q.getResultList();

        for (User u : results){
            System.out.println(u.toString());
        }
    }

    @Override
    public String getAllUsersFromDatabaseGson() {
        Query q = em.createQuery("select c from User c");

        List<User> results = q.getResultList();

        return gson.toJson(results);
    }

    public List<User> getAllUsersFromDatabaseGsonDeserialized(){
        Type itemsListType = new TypeToken<List<User>>() {}.getType();
        return gson.fromJson(getAllUsersFromDatabaseGson(), itemsListType);
    }

    @Override
    public String getAllUnverifiedUsersFromDatabaseGson() {
        Query q = em.createQuery("select l.user from Login l where l.enabled = false");

        List<User> results = q.getResultList();

        return gson.toJson(results);
    }

    @Override
    public String getAllWorkersFromDatabaseGson() {
        Query q = em.createQuery("select w from ServiceWorker w");

        List<ServiceWorker> results = q.getResultList();

        return gson.toJson(results);
    }

    @Override
    public void addNewWorkerToDatabase(JsonObject workerJson) {
        ServiceWorker worker = new ServiceWorker();
        User workerUser = new User();
        Login workerUserLogin = new Login();
        Position workerPosition = new Position();
        workerUser.setEmail(workerJson.get("email").getAsString());
        workerUser.setFirstName(workerJson.get("firstName").getAsString());
        workerUser.setLastName(workerJson.get("lastName").getAsString());
        workerUser.setPhone(workerJson.get("phone").getAsString());
        workerUserLogin.setLogin(workerJson.get("login").getAsString());
        workerUserLogin.setPassword(workerJson.get("password").getAsString());
        workerUserLogin.setEnabled(true);
        workerUserLogin.setRole("ROLE_WORKER");
        workerUserLogin.setUser(workerUser);
        workerPosition.setPositionId(workerJson.get("positionId").getAsInt());
        worker.setPosition(workerPosition);
        worker.setUser(workerUser);
        ServiceWorkersWorker sww = new ServiceWorkersWorker();
        sww.addServiceWorker(worker);

        System.out.println("Worker successfully added.");
    }
}