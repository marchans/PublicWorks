package database.dao.api;

import database.data.roles.Customer;

public interface CustomersDao {
	Customer addCustomer(Customer customer);

	Customer getCustomer(int id);

	void saveCustomer(Customer customer);

	String getAllUnverifiedCustomersFromDatabaseGson();

	void acceptUnverifiedCustomer(int customer_id);

	void rejectUnverifiedCustomer(int customer_id);

}