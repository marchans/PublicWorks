package database.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import database.data.users.User;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import database.dao.api.UtilityBillsDao;
import database.data.utilities.UtilityBill;

@Repository
@Transactional
public class UtilityBillsDaoJPA implements UtilityBillsDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public UtilityBill addUtilityBill(UtilityBill bill) {
        em.persist(bill);
        return bill;
    }

    @Override
    public UtilityBill getUtilityBill(int id) {
        return em.find(UtilityBill.class, id);
    }

    @Override
    public void saveUtilityBill(UtilityBill bill) {
        em.merge(bill);
    }
}
