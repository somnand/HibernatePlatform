package code;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import types.Manager;
import types.Vehicle;
import util.StaticHibernateUtils;

public class HibernateOneToManyMapping {

	private static final String CONFIG_FILE="hibernate_hr_schema.cfg.xml";
	
	public static void main(String[] args)throws HibernateException {
		//Getting SessionFactory
		SessionFactory factory=StaticHibernateUtils.getFactory(CONFIG_FILE);
		Session session=factory.openSession();
		Manager manager=new Manager();
				
		Vehicle vehicle1=new Vehicle();
		vehicle1.setVehicleName("Jeep");
		Vehicle vehicle2=new Vehicle();
		vehicle2.setVehicleName("Bike");
		
		
		manager.getVehicles().add(vehicle1);
		manager.getVehicles().add(vehicle2);
		vehicle1.setManager(manager);
		vehicle2.setManager(manager);
		//Getting Transaction
		Transaction txn=session.beginTransaction();
		try
		{
			session.save(manager);
			session.save(vehicle1);
			session.save(vehicle2);
			
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
