package types;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="address")
@Access(value=AccessType.FIELD)
public class Address {

	@Id@GeneratedValue
	@Column(name="address_id")
	//@Column(name="emp_id",unique=true,nullable=false)
	//@GeneratedValue(generator="gen")
	//@GenericGenerator(name="gen",strategy="foreign",parameters={@Parameter(name="property",value="employee")})
	private long id;
	@Column(name="addressLine1")
	private String addressLine1;
	
	/*@OneToOne
	@JoinColumn(name="employee_id")
	Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}*/
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	
}
