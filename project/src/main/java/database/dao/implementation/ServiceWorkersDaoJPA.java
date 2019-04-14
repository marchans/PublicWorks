package database.dao.implementation;

import database.dao.api.ServiceWorkersDao;
import database.data.roles.workers.ServiceWorker;
import javax.persistence.*;

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

}
