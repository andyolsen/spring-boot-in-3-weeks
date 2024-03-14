package demo.springdata;

import jakarta.persistence.*;

@Entity
@Table(name="EMPLOYEES")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id = null;

	private String name;
	private String region;

	@Column(name="salary")
	private double dosh;

	public Employee() {
	}

	public Employee(String name, double dosh, String region) {
		this.name = name;
		this.dosh = dosh;
		this.region = region;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDosh() {
		return dosh;
	}

	public void setDosh(double dosh) {
		this.dosh = dosh;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof Employee otherEmployee &&
				this.id == otherEmployee.id;
	}

	@Override
	public int hashCode() {
		return id.intValue();
	}

	@Override
	public String toString() {
		return String.format("Employee [id=%s, name=%s, region=%s, dosh=%s]", id, name, region, dosh);
	}
}