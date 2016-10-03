package code;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import types.Employee;
import types.Manager;
import types.Vehicle;
import util.StaticHibernateUtils;

public class HibernateOneToOneMapping {

	private static final String CONFIG_FILE="hibernate_hr_schema.cfg.xml";
	
	public static void main(String[] args)throws HibernateException {
		//Getting SessionFactory
		SessionFactory factory=StaticHibernateUtils.getFactory(CONFIG_FILE);
		Session session=factory.openSession();
		
		//SimpleEntity se=new SimpleEntity("Test Entity");
		
		
		Employee employee = new Employee();
		employee.setName("Fin-Employee-1");
		
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("Car");				
		
		employee.setVehicle(vehicle);
		
		//Getting Transaction
		Transaction txn=session.beginTransaction();
		try
		{
			session.save(employee);
			session.save(vehicle);
			
			
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
