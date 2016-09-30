package hiberproj;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

	public class HiberUtility {
	
	static SessionFactory factory;
	
	
	static{
		  Configuration cfg=new Configuration().configure();
		  factory=cfg.buildSessionFactory();
		  }
		
	
	private static final ThreadLocal<Session> tLocal =new ThreadLocal<Session>();

	public static Session getSession() {
			
			Session session=tLocal.get();
			if(session==null){
				
				session=factory.openSession();
				tLocal.set(session);
				return session;
			}
			else
			{
				return session;
			}
			}		

	public static void closeSession(Exception e) {
	
		Session session=tLocal.get();
		
				if(session!=null){
					if(e==null){
						session.beginTransaction().commit();
						session.close();
						tLocal.remove();
					}
				}
				else
				{
					session.beginTransaction().rollback();
					session.close();
					tLocal.remove();
				}
			
		
			}
		
		}	


	
	
	
	
	
	
	
	
	
	

