package database.data.requests;

import javax.persistence.*;

import database.data.roles.Customer;
import database.data.roles.workers.ServiceWorker;

@Entity
@Table(name = "requests")
public class Request {

	@Id
	@GeneratedValue
	@Column(name = "req_id")
	private int requestId;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "message")
	private String message;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "worker_id")
	private ServiceWorker worker;

	/**
	 * @return the requestId
	 */
	public int getRequestId() {
		return requestId;
	}

	/**
	 * @param requestId the requestId to set
	 */
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the worker
	 */
	public ServiceWorker getWorker() {
		return worker;
	}

	/**
	 * @param worker the worker to set
	 */
	public void setWorker(ServiceWorker worker) {
		this.worker = worker;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", status=" + status + ", message=" + message + ", customer="
				+ customer + ", worker=" + worker + "]";
	}
	
	
	
}
