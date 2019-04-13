package database.data.roles;

import javax.persistence.*;

import database.data.users.User;

@Entity
@Table(name="customers")
public class Customer {

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "customer_id")
	private User user;

	@Column(name = "passport")
	private String passport;
	
	@Column(name = "itn")
	private int itn;

	@Column(name = "county")
	private String county;

	@Column(name = "city")
	private String city;

	@Column(name = "district")
	private String district;
	
	@Column(name = "street")
	private String street;

	@Column(name = "number")
	private int number;
	
	@Column(name = "apt_number")
	private int aptNumber;
	
	@Column(name = "area")
	private double area;
	
	@Column(name = "account_number")
	private int accountNumber;

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
	 * @return the passport
	 */
	public String getPassport() {
		return passport;
	}

	/**
	 * @param passport the passport to set
	 */
	public void setPassport(String passport) {
		this.passport = passport;
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
		return "Customer [user=" + user + ", itn=" + itn + ", street=" + street + ", number=" + number + ", aptNumber="
				+ aptNumber + ", district=" + district + ", city=" + city + ", county=" + county + ", area=" + area
				+ ", accountNumber=" + accountNumber + "]";
	}
	
}
