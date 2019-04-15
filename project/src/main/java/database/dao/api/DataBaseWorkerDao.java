package database.dao.api;

import com.google.gson.Gson;
import database.data.users.User;
import database.data.utilities.UtilityBill;

import java.util.List;

public interface DataBaseWorkerDao {
    void getAllUsersFromDatabase();

    String getAllUsersFromDatabaseGson();

    List<User> getAllUsersFromDatabaseGsonDeserialized();
    
    public List<UtilityBill> getAllBillsForCustomer(int customerId);
}
