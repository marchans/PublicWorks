package database.dao.api;

import database.data.utilities.Utility;

public interface UtilitiesDao {
    Utility addUtility(Utility bill);

    Utility getUtility(int id);

    void saveUtility(Utility bill);
}
