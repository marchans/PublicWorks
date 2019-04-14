package database.workers;

import org.springframework.beans.factory.annotation.Autowired;

import database.dao.api.CustomersDao;
import database.data.roles.Customer;

public class CustomersWorker {
	@Autowired
	CustomersDao customersDao;
	
	public Customer addCustomer(Customer customer) {
		customer = customersDao.addCustomer(customer);
		System.out.println(customer);
		return customer;
	}
}
