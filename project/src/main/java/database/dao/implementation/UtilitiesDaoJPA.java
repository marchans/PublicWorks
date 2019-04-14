package database.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import database.dao.api.UtilitiesDao;
import database.data.utilities.Utility;

public class UtilitiesDaoJPA implements UtilitiesDao {

	  @PersistenceContext
	    private EntityManager em;

	    @Override
	    public Utility addUtility(Utility utility) {
	        em.persist(utility);
	        return utility;
	    }

	    @Override
	    public Utility getUtility(int id) {
	        return em.find(Utility.class, id);
	    }

	    @Override
	    public void saveUtility(Utility utility ) {
	        em.merge(utility);
	    }

}
