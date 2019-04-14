package test.database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import database.data.roles.Customer;
import database.data.users.Login;
import database.data.users.User;
import database.workers.CustomersWorker;
import database.workers.LoginsWorker;
import database.workers.UsersWorker;

public class TestDBApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("DatabaseBeans.xml");
		User u = new User();
		u.setFirstName("Jay");
		u.setLastName("Jay");
		u.setEmail("jay@jay.gmail.com");
		u.setPhone("0445554444");
		
		UsersWorker uw = (UsersWorker) context.getBean("usersWorker");
		uw.addUser(u);
		
		Login lu = new Login();
		lu.setUser(u);
		lu.setLogin("CustomerTest3");
		lu.setPassword("boom");
		lu.setRole("ROLE_USER");
		
		LoginsWorker lw = (LoginsWorker) context.getBean("loginsWorker");
		lw.addLogin(lu);
		
		Customer cu = new Customer();
		cu.setUser(u);
		cu.setAccountNumber(01);
		cu.setAptNumber(1);
		cu.setArea(33);
		cu.setCity("Kiev");
		cu.setCounty("Kiev");
		cu.setDistrict("Podil");
		cu.setItn(3323667);
		cu.setNumber(3);
		cu.setPassport("A54467");
		cu.setStreet("Khreshchatyk");
		
		System.out.println(cu);
//		
		CustomersWorker cuw = (CustomersWorker) context.getBean("customersWorker");
		cuw.addCustomer(cu);
	}

}
