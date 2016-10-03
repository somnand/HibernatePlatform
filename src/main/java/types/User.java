package types;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="hibernate_user")
public class User {

	@Id @GeneratedValue
	@Column(name="user_id")
	private Integer userId;
	@Column(name="user_name")	
	private String userName;
	@ManyToMany(mappedBy="users")
	private Collection<RentedVehicle> listOfVehicles=new ArrayList<RentedVehicle>();

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Collection<RentedVehicle> getListOfVehicles() {
		return listOfVehicles;
	}

	public void setListOfVehicles(Collection<RentedVehicle> listOfVehicles) {
		this.listOfVehicles = listOfVehicles;
	}
	
}
