package database.workers;

import com.google.gson.JsonObject;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import database.dao.api.ServiceWorkersDao;
import database.data.roles.workers.ServiceWorker;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation= Propagation.SUPPORTS)
public class ServiceWorkersWorker {
	@Autowired
	ServiceWorkersDao serviceWorkersDao;

	public ServiceWorker addServiceWorker(ServiceWorker serviceWorker) {
		serviceWorker = serviceWorkersDao.addServiceWorker(serviceWorker);
		System.out.println(serviceWorker);
		return serviceWorker;
	}

	public void addNewWorkerToDatabase(JsonObject workerJson){
		serviceWorkersDao.addNewWorkerToDatabase(workerJson);
	}

	public void deleteServiceWorker(int worker_id){
		serviceWorkersDao.deleteServiceWorker(worker_id);
	}
}