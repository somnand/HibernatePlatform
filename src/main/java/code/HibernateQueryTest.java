package code;



import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.StaticHibernateUtils;

public class HibernateQueryTest {

	private static final String CONFIG_FILE="hibernate_hr_schema.cfg.xml";
	
	public static void main(String[] args)throws HibernateException {
		//Getting SessionFactory
		SessionFactory factory=StaticHibernateUtils.getFactory(CONFIG_FILE);
		Session session=factory.openSession();
		
		//Getting Transaction
		//Transaction txn=session.beginTransaction();
		try
		{
			Query query = session.createSQLQuery("call add_job_history(:empId,:startDate,:endDate,:jobId,deptId");
			query.setParameter(1, "104");
			query.setParameter(2, new java.sql.Date(new Date().getTime()));
			query.setParameter(3, new java.sql.Date(new Date().getTime()));
			query.setParameter(4, "ST_CLERK");
			query.setParameter(5, "60");
			
			List result=query.list();
				
			
			//txn.commit();
		}
		catch(HibernateException he)
		{
			//txn.rollback();
			System.out.println(he.getMessage());
		}
		finally{
			session.close();
			factory.close();
		}
		
		

	}

}
