package database.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.google.gson.Gson;
import database.data.users.Login;
import database.data.users.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import database.dao.api.CustomersDao;
import database.data.roles.Customer;

import java.util.List;


@Repository
@Transactional
public class CustomersDaoJPA implements CustomersDao {

	@PersistenceContext
	private EntityManager em;

	private Gson gson = new Gson();

	@Override
	public Customer addCustomer(Customer customer) {
		em.persist(customer);
		return customer;
	}

	@Override
	public Customer getCustomer(int id) {
		Query q = em.createQuery("select c.id from Customer c where c.user.userId = :user_id");
		q.setParameter("user_id", id);
		int customer_id = (Integer)q.getSingleResult();
		return em.find(Customer.class, customer_id);
	}

	@Override
	public void saveCustomer(Customer customer) {
		em.merge(customer);
	}

	@Override
	public String getAllUnverifiedCustomersFromDatabaseGson() {
		Query q = em.createQuery("select c from Customer c where c.user in (select l.user from Login l where l.enabled = 0)");

		List<Customer> results = q.getResultList();

		return gson.toJson(results);
	}

	@Override
	public void acceptUnverifiedCustomer(int customer_id) {
		Query q = em.createQuery("update Login l set l.enabled = 1 where l.user.userId = :customer_id");
		q.setParameter("customer_id", customer_id);
		int i = q.executeUpdate();
	}

	@Override
	public void rejectUnverifiedCustomer(int customer_id) {
		Query q = em.createQuery("select c.user.userId from Customer c where c.user.userId = :user_id");
		q.setParameter("user_id", customer_id);
		int userToDeleteId = (Integer)q.getSingleResult();
		em.remove(em.find(User.class, userToDeleteId));
	}

}