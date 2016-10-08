package types;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="hibernate_manager")
public class Manager {

	@Id @GeneratedValue
	@Column(name="MANAGER_ID")
	private Integer managerId;
	
	@OneToMany(mappedBy="manager")
	/*@JoinTable(name="manager_vehicle",
	joinColumns=@JoinColumn(name="MANAGER_ID"),
	inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))*/
	private Collection<Vehicle> vehicles=new ArrayList<Vehicle>();
	
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
}
