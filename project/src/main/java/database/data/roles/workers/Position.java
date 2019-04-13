package database.data.roles.workers;

import javax.persistence.*;

@Entity
@Table(name = "positions")
public class Position {
	
	@Id
	@GeneratedValue
	@Column(name = "position_id")
	private int positionId;
	
	@Column(name = "name")
	private String position;

	/**
	 * @return the positionId
	 */
	public int getPositionId() {
		return positionId;
	}

	/**
	 * @param positionId the positionId to set
	 */
	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Position [positionId=" + positionId + ", position=" + position + "]";
	}
	
	
}
