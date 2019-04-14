package database.data.utilities;

import javax.persistence.*;

@Entity
@Table(name = "utilities")
public class Utility {
	@Id
	@GeneratedValue
	@Column(name = "utility_id")
	private int utilityId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private double price;

	/**
	 * @return the utilityId
	 */
	public int getUtilityId() {
		return utilityId;
	}

	/**
	 * @param utilityId the utilityId to set
	 */
	public void setUtilityId(int utilityId) {
		this.utilityId = utilityId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Utility [utilityId=" + utilityId + ", name=" + name + ", price=" + price + "]";
	}

	
	
}
