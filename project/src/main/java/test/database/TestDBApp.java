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
import database.data.utilities.Utility;
import database.data.utilities.UtilityBill;
import database.workers.LoginsWorker;
import database.workers.PositionsWorker;
import database.workers.ServiceWorkersWorker;
import database.workers.UsersWorker;
import database.workers.UtilitiesWorker;
import database.workers.UtilityBillsWorker;

import java.util.List;

public class TestDBApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("DatabaseBeans.xml");
//		User u = new User();
//		u.setFirstName("Jay");
//		u.setLastName("Worker");
//		u.setEmail("jay@worker.gmail.com");
//		u.setPhone("0445554444");
//
//		UsersWorker uw = (UsersWorker) context.getBean("usersWorker");
//		uw.addUser(u);
//
//		Login lu = new Login();
//		lu.setUser(u);
//		lu.setLogin("worker001");
//		lu.setPassword("boom");
//		lu.setRole("ROLE_WORKER");
//
//		LoginsWorker lw = (LoginsWorker) context.getBean("loginsWorker");
//		lw.addLogin(lu);

//        Customer cu = new Customer();
//        cu.setUser(u);
//        cu.setAccountNumber(011);
//        cu.setAptNumber(1);
//        cu.setArea(33);
//        cu.setCity("Kiev");
//        cu.setCounty("Kiev");
//        cu.setDistrict("Podil");
//        cu.setItn(337);
//        cu.setNumber(3);
//        cu.setPassport("A1111");
//        cu.setStreet("Khreshchatyk");
//        System.out.println(cu);

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
//       swow.addServiceWorker(sw);

		CustomersWorker cuw = (CustomersWorker) context.getBean("customersWorker");

//		Utility u = new Utility();
//		u.setName("Cold water");
//		u.setPrice(2.34);

		UtilitiesWorker uw = (UtilitiesWorker) context.getBean("utilitiesWorker");
//		uw.addUtility(u);

		UtilityBill ub = new UtilityBill();
		Customer c = cuw.getCustomerByIdFromDb(1);

		System.out.println(c);
		
		ub.setCustomer(c);
//		
//		u = uw.getUtilityFromDb(0);
//		
//		System.out.println(u);
//		
		ub.setUtility(uw.getUtilityFromDb(1));
		
		System.out.println(ub.getUtility());
		
		ub.setAmount(6.8);
//		
		UtilityBillsWorker ubw = (UtilityBillsWorker) context.getBean("utilityBillsWorker");
		ubw.addUtilityBill(ub);

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