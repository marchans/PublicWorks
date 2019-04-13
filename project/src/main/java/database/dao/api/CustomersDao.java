package database.dao.api;

import database.data.roles.Customer;

public interface CustomersDao {
	Customer addCustomer(Customer Customer);

	Customer getCustomer(int id);

	void saveCustomer(Customer Customer);
}
