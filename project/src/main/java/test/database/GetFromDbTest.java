package test.database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import database.data.roles.Customer;
import database.data.utilities.UtilityBill;
import database.workers.CustomersWorker;

public class GetFromDbTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("DatabaseBeans.xml");

		CustomersWorker cuw = (CustomersWorker) context.getBean("customersWorker");

		for (int i = 0; i < 10; ++i) {
			Customer c = cuw.getCustomerByIdFromDb(i);
			if (c != null) {
				System.out.println("Customer: " + i + c);
				System.out.println(">>>>>>>>> Customer's bills: <<<<<<<<");
				for (UtilityBill b : c.getUtilityBills()) {
					System.out.println(b);
				}
			}
		}

	}

}
