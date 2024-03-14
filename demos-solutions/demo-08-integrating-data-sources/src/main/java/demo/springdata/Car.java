package demo.springdata;

import jakarta.persistence.*;

@Entity
@Table(name="CARS")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id = null;

	private String regnum;
	private String make;
	private String model;

	public Car() {
	}

	public Car(String regnum, String make, String model) {
		this.regnum = regnum;
		this.make = make;
		this.model = model;
	}

	public Long getId() {
		return id;
	}

    public void setId(Long id) {
		this.id = id;
	}
	
    public String getRegnum() {
		return regnum;
	}
	
	public void setRegnum(String regnum) {
		this.regnum = regnum;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}
	
    public void setModel(String model) {
		this.model = model;
	}
	
	@Override
	public boolean equals(Object other) {
		return other instanceof Car otherCar &&
				this.id == otherCar.id;
	}
	
	@Override 
	public int hashCode() {
		return id.intValue();
	}

	@Override
	public String toString() {
		return String.format(
				"Car [id=%s, regnum=%s, make=%s, model=%s]",
				id,
				regnum,
				make,
				model);
	}
}