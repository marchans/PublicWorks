package database.workers;

import org.springframework.beans.factory.annotation.Autowired;

import database.dao.api.ServiceWorkersDao;
import database.data.roles.workers.ServiceWorker;

public class ServiceWorkersWorker {
	@Autowired
	ServiceWorkersDao serviceWorkersDao;
	
	public ServiceWorker addServiceWorker(ServiceWorker serviceWorker) {
		serviceWorker = serviceWorkersDao.addServiceWorker(serviceWorker);
		System.out.println(serviceWorker);
		return serviceWorker;
	}
}
