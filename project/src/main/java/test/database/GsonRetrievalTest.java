package test.database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import database.dao.api.DataBaseWorkerDao;

public class GsonRetrievalTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("DatabaseBeans.xml");
		
		DataBaseWorkerDao dbdao = (DataBaseWorkerDao) context.getBean("dataBaseWorkerDao");
		
//		System.out.println(dbdao.getAllUsersFromDatabaseGson());
		
		System.out.println(dbdao.getAllBillsForCustomer(6));
	}

}
