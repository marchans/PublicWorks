package test.database;

import database.workers.DataBaseWorker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import database.data.users.Login;
import database.data.users.User;
import database.workers.LoginsWorker;
import database.workers.UsersWorker;

import javax.xml.crypto.Data;
import java.util.List;

public class TestDBApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("DatabaseBeans.xml");
//		User u = new User();
//		u.setFirstName("Jay");
//		u.setLastName("Jay");
//		u.setEmail("jay@jay.gmail.com");
//		u.setPhone("0445554444");
//
//		UsersWorker uw = (UsersWorker) context.getBean("usersWorker");
//		uw.addUser(u);
////
//		Login lu = new Login();
//		lu.setUser(u);
//		lu.setLogin("jayStar");
//		lu.setPassword("boom");
//		lu.setRole("ROLE_USER");
//
//		LoginsWorker lw = (LoginsWorker) context.getBean("loginsWorker");
//		lw.addLogin(lu);

	DataBaseWorker db = (DataBaseWorker) context.getBean("dataBaseWorker");

	System.out.println("Get all users from database as strings test: ");
	db.getAllUsersFromDatabase();

	System.out.println("Get all users from database as Gson test: ");
	System.out.println(db.getAllUsersFromDatabaseGson());

	System.out.println("Get all users from database as deserialized Gson test: ");
	List<User> list = db.getAllUsersFromDatabaseGsonDeserialized();
	for(User u : list){
		System.out.println(u.toString());
	}

//		uw.getAllUsersFromDatabase();
	
	}

}
