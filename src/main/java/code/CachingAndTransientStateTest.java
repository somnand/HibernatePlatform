package code;

import java.io.File;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import types.SimpleEntity;
import util.StaticHibernateUtils;

public class CachingAndTransientStateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		
		SessionFactory factory=null;
		File hibernateCfgFile=null;
		Transaction t=null;
		try
		{
			hibernateCfgFile=new File("hibernate_hr_schema.cfg.xml");
			factory=StaticHibernateUtils.getFactory("hibernate_hr_schema.cfg.xml");
			
			Session session=factory.openSession();
			t=session.beginTransaction();
			/*for(int i=1;i<=1E3;i++)
				session.save(new SimpleEntity("Entity Value "+i));
			t.commit();
			System.out.println(("Saved !!"));*/
			Query fetchSE=session.createQuery("from SimpleEntity se");
			//fetchSE.setParameter("idValue",1);
			List<SimpleEntity> seList=fetchSE.list();
			//SimpleEntity se1=(SimpleEntity)session.get(SimpleEntity.class, 1);
			seList.get(500).setSimpleValue("Entity Value -1");
			seList.get(500).setSimpleValue("Entity Value -2");
			t.commit();
		}
		catch(HibernateException e)
		{
			t.rollback();
			e.printStackTrace();
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
