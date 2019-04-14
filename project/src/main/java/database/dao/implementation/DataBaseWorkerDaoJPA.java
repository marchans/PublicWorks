package database.dao.implementation;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import database.dao.api.DataBaseWorkerDao;
import database.data.users.User;
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
}
