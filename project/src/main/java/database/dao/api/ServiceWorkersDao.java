package database.dao.api;

import com.google.gson.JsonObject;
import database.data.roles.workers.ServiceWorker;

public interface ServiceWorkersDao {
	ServiceWorker addServiceWorker(ServiceWorker serviceWorker);

	ServiceWorker getServiceWorker(int id);

	void saveServiceWorker(ServiceWorker serviceWorker);

	void addNewWorkerToDatabase(JsonObject workerJson);

	void deleteServiceWorker(int worker_id);
}