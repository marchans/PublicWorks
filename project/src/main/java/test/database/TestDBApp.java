package test.database;

import database.data.roles.Customer;
import database.data.roles.workers.Position;
import database.data.roles.workers.ServiceWorker;
import database.workers.CustomersWorker;
import database.workers.DataBaseWorker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import database.data.users.Login;
import database.data.users.User;
import database.workers.LoginsWorker;
import database.workers.PositionsWorker;
import database.workers.ServiceWorkersWorker;
import database.workers.UsersWorker;

import java.util.List;

public class TestDBApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("DatabaseBeans.xml");
		User u = new User();
		u.setFirstName("Jay");
		u.setLastName("User3");
		u.setEmail("worker1@worker.gmail.com");
		u.setPhone("88005553737");

		UsersWorker uw = (UsersWorker) context.getBean("usersWorker");
		uw.addUser(u);

		Login lu = new Login();
		lu.setUser(u);
		lu.setLogin("testcustomer33"); // unique
		lu.setPassword("legko");
		lu.setRole("ROLE_USER");

		LoginsWorker lw = (LoginsWorker) context.getBean("loginsWorker");
		lw.addLogin(lu);

		Customer cu = new Customer();
		cu.setUser(u);
		cu.setAccountNumber(33333); // unique
		cu.setAptNumber(2);
		cu.setArea(33);
		cu.setCity("Kiev");
		cu.setCounty("Kiev");
		cu.setDistrict("Podil");
		cu.setItn(333333333); //unique
		cu.setNumber(1);
		cu.setPassport("AA333333"); // unique
		cu.setStreet("Khreshchatyk");
		System.out.println(cu);

		CustomersWorker cuw = (CustomersWorker) context.getBean("customersWorker");
		cuw.addCustomer(cu);
////
//		ServiceWorkersWorker sww = (ServiceWorkersWorker) context.getBean("serviceWorkersWorker");
//		ServiceWorker sw = new ServiceWorker();
//		Position p = new Position();
//		p.setPosition("Електрик");
//		PositionsWorker pw = (PositionsWorker) context.getBean("positionsWorker");
//		pw.addPosition(p);
//		sw.setPosition(p);
//		sw.setUser(u);
//
//		sww.addServiceWorker(sw);


		
//		Position p = new Position();
//		p.setPosition("Electrician");
//		
//		PositionsWorker pw = (PositionsWorker) context.getBean("positionsWorker");
//		pw.addPosition(p);
//		
//		ServiceWorker sw = new ServiceWorker();
//		sw.setUser(u);
//		sw.setPosition(p);
//
//        ServiceWorkersWorker swow = (ServiceWorkersWorker) context.getBean("serviceWorkersWorker");
//        swow.addServiceWorker(sw);
//        

//
//		DataBaseWorker db = (DataBaseWorker) context.getBean("dataBaseWorker");
//
//		System.out.println("Get all users from database as strings test: ");
//		db.getAllUsersFromDatabase();
//
//		System.out.println("Get all users from database as Gson test: ");
//		System.out.println(db.getAllUsersFromDatabaseGson());
//
//		System.out.println("Get all users from database as deserialized Gson test: ");
//		List<User> list = db.getAllUsersFromDatabaseGsonDeserialized();
//		for(User user : list){
//			System.out.println(user.toString());
//		}

	}
}