package types;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="hibernate_vehicle")
public class Vehicle {

	@Id
	@GeneratedValue
	@Column(name="vehicle_id")
	private long id;
	@Column(name="vehicle_name")
	private String vehicleName;
	@ManyToOne
	@JoinColumn(name="vehicle_manager_id")
	private Manager manager;
	
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public long getId() {
		return id;
		
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}	
}
