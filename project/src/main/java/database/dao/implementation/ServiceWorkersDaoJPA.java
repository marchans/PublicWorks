package database.dao.implementation;

import com.google.gson.JsonObject;
import database.dao.api.ServiceWorkersDao;
import database.data.roles.workers.Position;
import database.data.roles.workers.ServiceWorker;
import javax.persistence.*;

import database.data.users.Login;
import database.data.users.User;
import database.workers.DataBaseWorker;
import database.workers.ServiceWorkersWorker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ServiceWorkersDaoJPA implements ServiceWorkersDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public ServiceWorker addServiceWorker(ServiceWorker serviceWorker) {
		em.persist(serviceWorker);
		//em.refresh(serviceWorker);
		return serviceWorker;
	}

	@Override
	public ServiceWorker getServiceWorker(int id) {
		return em.find(ServiceWorker.class, id);
	}

	@Override
	public void saveServiceWorker(ServiceWorker serviceWorker) {
		em.merge(serviceWorker);

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
		workerUserLogin.setEnabled(1);
		workerUserLogin.setRole("ROLE_WORKER");
		em.persist(workerUser);
		em.refresh(workerUser);
		workerUserLogin.setUser(workerUser);
		em.persist(workerUserLogin);
		workerPosition.setPositionId(Integer.parseInt(workerJson.get("positionId").getAsString()));
		worker.setPosition(workerPosition);
		worker.setUser(workerUser);
		addServiceWorker(worker);

		System.out.println("Worker successfully added.");
	}

	@Override
	public void deleteServiceWorker(int worker_id) {
		ServiceWorker toDelete = em.find(ServiceWorker.class, worker_id);
		int user_id = toDelete.getUser().getUserId();
		em.remove(em.find(User.class, user_id));

		System.out.println("Worker successfully removed.");
	}
}