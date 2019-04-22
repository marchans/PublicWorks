package database.workers;

import org.springframework.beans.factory.annotation.Autowired;

import database.dao.api.CustomersDao;
import database.data.roles.Customer;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS)
public class CustomersWorker {
	@Autowired
	CustomersDao customersDao;

	public Customer addCustomer(Customer customer) {
		customer = customersDao.addCustomer(customer);
		System.out.println(customer);
		return customer;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public String getAllUnverifiedCustomersFromDatabaseGson(){
		return customersDao.getAllUnverifiedCustomersFromDatabaseGson();
	}

	public void acceptUnverifiedCustomer(int customer_id){
		customersDao.acceptUnverifiedCustomer(customer_id);
	}

	public void rejectUnverifiedCustomer(int customer_id){
		customersDao.rejectUnverifiedCustomer(customer_id);
	}
}