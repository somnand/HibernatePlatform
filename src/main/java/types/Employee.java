package types;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hibernate_employee")
//@Access(value = AccessType.FIELD)
public class Employee {

	
	@Id
	@GeneratedValue
	@Column(name="emp_id")
	private long id;
	@Column(name="emp_name")
	private String name;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="address_id")
	private Address employeeAddress;
		
	public Address getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(Address employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		//return "Employee [id=" + id + ", name=" + name + ", employeeAddress="+ employeeAddress + "]";
		return "Employee [id=" + id + ", name=" + name + "]";
	}
}
