package database.data;

import javax.persistence.*;

@Entity
@Table(name="customers")
public class Customer {
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "customer_id")
	private User user;
	
	@Column(name = "itn")
	private int itn;
	
	@Column(name = "street")
	private String street;

	@Column(name = "number")
	private int number;
	
	@Column(name = "apt_number")
	private int aptNumber;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "county")
	private String county;
	
	@Column(name = "area")
	private double area;
	
	@Column(name = "account_number")
	private int accountNumber;

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the itn
	 */
	public int getItn() {
		return itn;
	}

	/**
	 * @param itn the itn to set
	 */
	public void setItn(int itn) {
		this.itn = itn;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the aptNumber
	 */
	public int getAptNumber() {
		return aptNumber;
	}

	/**
	 * @param aptNumber the aptNumber to set
	 */
	public void setAptNumber(int aptNumber) {
		this.aptNumber = aptNumber;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the county
	 */
	public String getCounty() {
		return county;
	}

	/**
	 * @param county the county to set
	 */
	public void setCounty(String county) {
		this.county = county;
	}

	/**
	 * @return the area
	 */
	public double getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(double area) {
		this.area = area;
	}

	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	

	
	
}
