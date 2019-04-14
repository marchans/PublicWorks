package database.dao.implementation;

import database.dao.api.PositionsDao;
import database.data.roles.workers.Position;
import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PositionsDaoJPA implements PositionsDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Position addPosition(Position position) {
		em.persist(position);
		return position;
	}

	@Override
	public Position getPosition(int id) {
		return em.find(Position.class, id);
	}

	@Override
	public void savePosition(Position position) {
		em.merge(position);

	}

}
