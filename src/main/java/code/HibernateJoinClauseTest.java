package code;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import types.OrderDetails;
import types.OrderHeader;
import util.StaticHibernateUtils;

public class HibernateJoinClauseTest {

	private static final String CONFIG_FILE="hibernate_hr_schema.cfg.xml";
	
	public static void main(String[] args)throws HibernateException {
		//Getting SessionFactory
		SessionFactory factory=StaticHibernateUtils.getFactory(CONFIG_FILE);
		Session session=factory.openSession();
		
		OrderHeader header1=new OrderHeader();
		OrderDetails detail1=new OrderDetails();
		OrderDetails detail2=new OrderDetails();
		
		header1.setOrder_value(10.0);
		header1.setOrder_time("2016-10-03");
		header1.setDelivery_charge("PAID");
		
		detail1.setPrice("20.0");
		detail1.setProduct_code("12");
		detail2.setPrice("20.0");
		detail2.setProduct_code("12");
		//Getting Transaction
		Transaction txn=session.beginTransaction();
		try
		{
			session.save(header1);
			session.save(detail1);
			session.save(detail2);
			
			txn.commit();
			
			OrderHeader orderHeader=(OrderHeader)session.get(OrderHeader.class, 1);
			//System.out.println(orderHeader);
			//System.out.println(orderHeader.getOrderDetailList());
			
			
			Criteria orderDetailCriteria=session.createCriteria(OrderHeader.class);
			orderDetailCriteria.setFetchMode("OrderHeader", FetchMode.JOIN);
			List<OrderHeader> list=orderDetailCriteria.list();
			
			for(OrderHeader header : list)
			{
				//System.out.println(header+" Details list\n: "+header.getOrderDetailList());
			}
			
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
