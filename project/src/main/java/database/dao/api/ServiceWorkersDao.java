package database.dao.api;

import database.data.roles.workers.ServiceWorker;

public interface ServiceWorkersDao {
	ServiceWorker addServiceWorker(ServiceWorker serviceWorker);

	ServiceWorker getServiceWorker(int id);

	void saveServiceWorker(ServiceWorker serviceWorker);
}
