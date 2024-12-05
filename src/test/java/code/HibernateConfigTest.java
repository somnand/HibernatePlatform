package code;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import util.StaticHibernateUtils;

/**
 * This is the First test that needs to be run in order to understand what configuration 
 * we are using for Hibernate Program Testing.
 * @author SomsuryaNanda
 *
 */
public class HibernateConfigTest 
{
	SessionFactory factory=null;
	File hibernateCfgFile=null;
	
	@Before
	public void setupDBConfig()
	{
		try
		{
			hibernateCfgFile=new File("hibernate_debry_db.cfg.xml");
			factory=StaticHibernateUtils.getFactory("hibernate_debry_db.cfg.xml");
			System.out.println("Connection Successfull!!!");
		}
		catch(HibernateException e)
		{
			//throw e;
		}		
	}
	
	@Test
	public void testConfig()throws HibernateException
	{
		try 
		{
			Assert.assertNotNull("Aborting the program as Hibernate Config is not present!!",hibernateCfgFile);
			Assert.assertNotNull("Error in establishing the connection!!\nUser: The Hibernate Config file is not correct", factory);
		}
		finally
		{
			if(factory!=null)
				factory.close();
		}
		
	}

}
