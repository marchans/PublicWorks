package database.dao.api;

import database.data.utilities.UtilityBill;

public interface UtilityBillsDao {
    UtilityBill addUtilityBill(UtilityBill bill);

    UtilityBill getUtilityBill(int id);

    void saveUtilityBill(UtilityBill bill);
}
