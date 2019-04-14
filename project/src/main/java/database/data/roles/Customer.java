package database.data.roles;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import database.data.users.User;
import database.data.utilities.UtilityBill;

@Entity
@Table(name="customers")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@OneToOne(cascade={CascadeType.MERGE})
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

	@OneToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	@Column(name = "bills")
	@ElementCollection(targetClass = UtilityBill.class)
	private Collection<UtilityBill> utilityBills = new ArrayList<UtilityBill>();
	
	/**
	 * @return the itn
	 */
	@Column(name = "itn")
	public int getItn() {
		return itn;
	}

	/**
	 * @param itn the itn to set
	 */
	@Column(name = "itn")
	public void setItn(int itn) {
		this.itn = itn;
	}

	/**
	 * @return the passport
	 */
	@Column(name = "passport")
	public String getPassport() {
		return passport;
	}

	/**
	 * @param passport the passport to set
	 */
	@Column(name = "passport")
	public void setPassport(String passport) {
		this.passport = passport;
	}


	/**
	 * @return the street
	 */
	@Column(name = "street")
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	@Column(name = "street")
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the number
	 */
	@Column(name="number")
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	@Column(name = "number")
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the aptNumber
	 */
	@Column(name = "apt_number")
	public int getAptNumber() {
		return aptNumber;
	}

	/**
	 * @param aptNumber the aptNumber to set
	 */
	@Column(name = "apt_number")
	public void setAptNumber(int aptNumber) {
		this.aptNumber = aptNumber;
	}

	/**
	 * @return the district
	 */
	@Column(name = "district")
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	@Column(name = "district")
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the city
	 */
	@Column(name = "city")
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	@Column(name = "city")
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the county
	 */
	@Column(name = "county")
	public String getCounty() {
		return county;
	}

	/**
	 * @param county the county to set
	 */
	@Column(name = "county")
	public void setCounty(String county) {
		this.county = county;
	}

	/**
	 * @return the area
	 */
	@Column(name="area")
	public double getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	@Column(name="area")
	public void setArea(double area) {
		this.area = area;
	}

	/**
	 * @return the accountNumber
	 */
	@Column(name="account_number")
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	@Column(name="account_number")
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the user
	 */
	@OneToOne(cascade={CascadeType.MERGE})
	@JoinColumn(name = "customer_id")
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */

	public void setUser(User user) {
		this.user = user;
	}


	/**
	 * @return the id
	 */
	@Id
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	@Id
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the utilityBills
	 */
	@OneToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	@Column(name = "bills")
	@ElementCollection(targetClass = UtilityBill.class)
	public Collection<UtilityBill> getUtilityBills() {
		return utilityBills;
	}

	/**
	 * @param utilityBills the utilityBills to set
	 */
	@OneToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	@Column(name = "bills")
	@ElementCollection(targetClass = UtilityBill.class)
	public void setUtilityBills(Collection<UtilityBill> utilityBills) {
		this.utilityBills = utilityBills;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [id=" + id + ", user=" + user + ", passport=" + passport + ", itn=" + itn + ", county="
				+ county + ", city=" + city + ", district=" + district + ", street=" + street + ", number=" + number
				+ ", aptNumber=" + aptNumber + ", area=" + area + ", accountNumber=" + accountNumber + ", utilityBills="
				+ utilityBills + "]";
	}
	
}
