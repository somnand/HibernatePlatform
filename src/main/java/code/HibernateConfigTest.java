package code;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import util.StaticHibernateUtils;

public class HibernateConfigTest {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		
		SessionFactory factory=null;
		File hibernateCfgFile=null;
		try
		{
			hibernateCfgFile=new File("hibernate_debry_db.cfg.xml");
			factory=StaticHibernateUtils.getFactory("hibernate_debry_db.cfg.xml");
			System.out.println("Connection Successfull!!!");
		}
		catch(HibernateException e)
		{
			throw e;
		}
		finally
		{
			if(hibernateCfgFile==null)
			{
				System.out.println("Aborting the program as Hibernate Config is not present!!");
				
			}
			if(factory==null)
			{
				System.out.println("Error in establishing the connection!!");
				System.exit(1);
			}
			factory.close();
		}
	}

}
