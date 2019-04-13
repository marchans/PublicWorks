package test.database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import database.data.users.User;
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
	
	}

}
