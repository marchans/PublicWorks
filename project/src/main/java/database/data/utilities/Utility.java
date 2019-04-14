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
	
}
