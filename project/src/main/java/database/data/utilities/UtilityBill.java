package database.data.utilities;

import javax.persistence.*;

@Entity
@Table(name = "utility_bills")
public class UtilityBill {
	
	@Id
	@GeneratedValue
	@Column(name = "bill_id")
	private int billId;
	
	@ManyToOne
	@JoinColumn(name = "utility_id")
	private Utility utility;
	
	@Column(name = "amount")
	private double amount;

	/**
	 * @return the billId
	 */
	public int getBillId() {
		return billId;
	}

	/**
	 * @param billId the billId to set
	 */
	public void setBillId(int billId) {
		this.billId = billId;
	}

	/**
	 * @return the utility
	 */
	public Utility getUtility() {
		return utility;
	}

	/**
	 * @param utility the utility to set
	 */
	public void setUtility(Utility utility) {
		this.utility = utility;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UtilityBill [billId=" + billId + ", utility=" + utility + ", amount=" + amount + "]";
	}
	
	
}
