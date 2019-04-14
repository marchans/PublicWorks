package database.workers;

import org.springframework.beans.factory.annotation.Autowired;

import database.dao.api.UtilitiesDao;
import database.data.utilities.Utility;

public class UtilitiesWorker {
	@Autowired
	UtilitiesDao utilitiesDao;

	public Utility addUtility(Utility utility) {
		utility = utilitiesDao.addUtility(utility);
		System.out.println(utility);
		return utility;
	}

	public Utility getUtilityFromDb(int utilityId) {
		return utilitiesDao.getUtility(utilityId);
	}
}
