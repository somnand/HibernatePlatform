package code;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import types.Employee;
import types.Manager;
import types.RentedVehicle;
import types.User;
import types.Vehicle;
import util.StaticHibernateUtils;

public class HibernateManyToManyMapping {

	private static final String CONFIG_FILE="hibernate_debry_db.cfg.xml";
	
	public static void main(String[] args)throws HibernateException {
		//Getting SessionFactory
		SessionFactory factory=StaticHibernateUtils.getFactory(CONFIG_FILE);
		Session session=factory.openSession();
		
		//Creating the User objects
		User user1=new User();
		User user2=new User();
		User user3=new User();
		
		RentedVehicle vehicle1=new RentedVehicle();
		RentedVehicle vehicle2=new RentedVehicle();
		
		user1.setUserName("Amit");
		user2.setUserName("Praveen");
		user3.setUserName("Kishore");
		
		vehicle1.setVehicleName("Car");
		vehicle2.setVehicleName("Bike");
		
		user1.getListOfVehicles().add(vehicle1);
		user1.getListOfVehicles().add(vehicle2);
		user2.getListOfVehicles().add(vehicle1);
		user3.getListOfVehicles().add(vehicle2);
		
		vehicle1.getUsers().add(user1);vehicle1.getUsers().add(user2);
		vehicle1.getUsers().add(user1);vehicle1.getUsers().add(user3);
		
		//Getting Transaction
		Transaction txn=session.beginTransaction();
		try
		{
			session.save(user1);session.save(user2);session.save(user3);
			session.save(vehicle1);session.save(vehicle2);	
			
			txn.commit();
		}
		catch(HibernateException he)
		{
			txn.rollback();
			System.out.println(he.getMessage());
		}
		finally{
			session.close();
			factory.close();
		}
		
		

	}

}
