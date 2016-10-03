package types;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="hibernate_rented_vehicle")
public class RentedVehicle {

	@Id @GeneratedValue @Column(name="vehicle_id")
	private Integer rentedVehicleId;
	@Column(name="vehicle_name")
	private String vehicleName;
	@ManyToMany
	@JoinTable(name="interim_table")
	private Collection<User> users=new ArrayList<User>();

	public Integer getRentedVehicleId() {
		return rentedVehicleId;
	}

	public void setRentedVehicleId(Integer rentedVehicleId) {
		this.rentedVehicleId = rentedVehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}
	
}
