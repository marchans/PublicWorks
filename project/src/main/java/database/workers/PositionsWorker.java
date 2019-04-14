package database.workers;

import org.springframework.beans.factory.annotation.Autowired;

import database.dao.api.PositionsDao;
import database.data.roles.workers.Position;

public class PositionsWorker {
	@Autowired
	PositionsDao positionsDao;
	
	public Position addPosition(Position position) {
		position = positionsDao.addPosition(position);
		System.out.println(position);
		return position;
	}
}
