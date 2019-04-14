package database.workers;

import org.springframework.beans.factory.annotation.Autowired;

import database.dao.api.UtilityBillsDao;
import database.data.utilities.UtilityBill;

public class UtilityBillsWorker {
	@Autowired
	UtilityBillsDao utilityBillsDao;

	public UtilityBill addUtilityBill(UtilityBill bill) {
		bill = utilityBillsDao.addUtilityBill(bill);
		System.out.println(bill);
		return bill;
	}

	public UtilityBill getUtilityFromDb(int id) {
		return utilityBillsDao.getUtilityBill(id);
	}
}
