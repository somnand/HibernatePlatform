package code;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import util.StaticHibernateUtils;

public class HibernateConfigTest 
{
	private static final String ORACLE_CONFIG_FILE = "hibernate_hr_schema.cfg.xml";
	private static final String DEBRY_CONFIG_FILE = "hibernate_debry_db.cfg.xml";

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		
		SessionFactory factory=null;
		File hibernateCfgFile=null;
		try
		{
			hibernateCfgFile=new File(ORACLE_CONFIG_FILE);
			factory=StaticHibernateUtils.getFactory(ORACLE_CONFIG_FILE);
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
