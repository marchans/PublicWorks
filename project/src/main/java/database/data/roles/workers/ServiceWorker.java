package database.data.roles.workers;

import javax.persistence.*;

import database.data.users.User;

@Entity
@Table(name = "service_workers")
public class ServiceWorker {
	@Id
	@GeneratedValue
	@Column(name = "worker_id")
	private int workerId;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "position_id")
	private Position position;
	
	@OneToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "user_id")
	private User user;

	/**
	 * @return the workerId
	 */
	public int getWorkerId() {
		return workerId;
	}

	/**
	 * @param workerId the workerId to set
	 */
	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ServiceWorker [workerId=" + workerId + ", position=" + position + ", user=" + user + "]";
	}
	
	
}
