package database.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import database.dao.api.CustomersDao;
import database.data.roles.Customer;


@Repository
@Transactional
public class CustomersDaoJPA implements CustomersDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Customer addCustomer(Customer customer) {
		em.persist(customer);
		return customer;
	}

	@Override
	public Customer getCustomer(int id) {
		return em.find(Customer.class, id);
	}

	@Override
	public void saveCustomer(Customer customer) {
		em.merge(customer);
	}

}
