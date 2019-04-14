package database.dao.api;

import database.data.roles.workers.Position;;

public interface PositionsDao {
	Position addPosition(Position position);

	Position getPosition(int id);

	void savePosition(Position position);
}