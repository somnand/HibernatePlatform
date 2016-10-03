package util;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.TransientObjectException;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class StaticHibernateUtils 
{
	/**
	 * @param cfgFile
	 * @return SessionFactory
	 */
	@SuppressWarnings(value={"deprecation"})
	public static SessionFactory getFactoryWithServiceRegistry(String cfgFile)throws HibernateException
	{
		
		Configuration cfg=new AnnotationConfiguration();
		cfg.configure(cfgFile);
		
		String prop=cfg.getProperty("show_sql");
		System.out.println("Property : "+prop);
		
		//Fetching configuration Properties
		Properties configProps=cfg.getProperties();
		//Building the ServiceRegistryBuilder and adding configuration to it.
		StandardServiceRegistryBuilder registryBuilder = new ServiceRegistryBuilder();
		registryBuilder.applySettings(configProps);
		//Creating ServiceRegistry from Builder
		ServiceRegistry serviceRegistry=registryBuilder.getBootstrapServiceRegistry();
		//Building the SessionFactory with the service registry.	
		SessionFactory sessionFactory=cfg.buildSessionFactory(serviceRegistry);
		//SessionFactory sessionFactory=cfg.buildSessionFactory();
		return sessionFactory;
	}
	
	/**
	 * @param cfgFile
	 * @return SessionFactory
	 * The method returns SessionFactory object without using the ServiceRegistry. 
	 */
	@SuppressWarnings(value={"deprecation"})
	public static SessionFactory getFactory(String cfgFile)throws HibernateException
	{
		
		Configuration cfg=new AnnotationConfiguration();
		cfg.configure(cfgFile);
		SessionFactory sessionFactory=cfg.buildSessionFactory();
		return sessionFactory;
	}
	
	/**
	 * Method for saving the object. It saves a single unlinked of unmapped Entity.
	 * This method can't be used with any Linked Entities.(ie. with Foreign Key relation in POJOs)
	 * exception thrown in case it is used is :
	 *  org.hibernate.TransientObjectException 
	 * @param session 
	 * For the session used for saving the POJO
	 * @param entity 
	 * Entity for saving into database 
	 * @exception HibernateException
	 */
	public static void saveEntity(Session session,Object entity)throws HibernateException
	{
		Transaction tx=session.beginTransaction();
		try
		{
			session.save(entity);
			tx.commit();
		}
		catch(TransientObjectException toe)
		{
			System.out.println("Can't save foreign key linked objects");
			tx.rollback();
			throw toe;
		}
		catch(HibernateException he)
		{
			tx.rollback();
			throw he;
		}
		
	}
	
	/**
	 * Method for saving linked Entities.  
	 * @param session 
	 * For the session used for saving the POJO
	 * @param entity 
	 * Entity for saving into database 
	 * @exception HibernateException
	 */
	public static void saveEntity(Session session,Object... entity)throws HibernateException
	{
		Transaction tx=session.beginTransaction();
		try
		{
			int i=0;
			while(i<entity.length)
			{
				session.save(entity[i]);
				i++;
			}
			tx.commit();
		}
		catch(HibernateException he)
		{
			tx.rollback();
			throw he;
		}		
	}
	
	
	/**
	 * Method for getting the object
	 * @param session 
	 * For the session used for saving the POJO
	 * @param retrievingClass  
	 * Class which denotes the entity to be fetched from the DB 
	 * @param id
	 * The Id value of the object. This is the parameter with the @Id attribute 
	 */
	public static Object getEntity(Session session,Class retrievingClass,int id)
	{
		Object entity=null;
		Transaction tx=session.beginTransaction();
		try
		{
			entity=session.get(retrievingClass,id);
			return entity;
		}
		catch(HibernateException he)
		{
			tx.rollback();
			throw he;
		}	
	}
}
