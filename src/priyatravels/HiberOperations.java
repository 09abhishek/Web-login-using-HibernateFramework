package priyatravels;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hiberproj.HiberUtility;
import hiberproj.UserEntity;



public class HiberOperations {
	Session session;
	
	public boolean checkUser(String uname)
	{
		 session=HiberUtility.getSession();
		
		String hql = "FROM UserEntity where uname = :username";
		
		Query query = session.createQuery(hql);
		
		query.setParameter("username",uname);
		
		@SuppressWarnings("unchecked")
		List<UserEntity> results = query.list();
		
		Iterator<UserEntity> it=results.iterator();
		
		if (it.hasNext()) {
			
			return true;
		}
		else
		{
			
		return false;
		}
	
	}
	
	
	public boolean changeStatus(String uname,int status)
	{
		 session=HiberUtility.getSession();
		
		Query query = session.createQuery("update UserEntity set status = :statusval where uname = :unameval");
		
		query.setParameter("statusval",status);
		query.setParameter("unameval",uname);
		
		if (query.executeUpdate()==1) {
			
			HiberUtility.closeSession(null);
			return true;
		}
		else
		{
			return false;
		}
		
		
		
	}
	
	public boolean checkUserAndPassword(String uname,String password){
		
		
		 session=HiberUtility.getSession();	
		String hql = "FROM UserEntity where uname = :username AND upass= :password";
		Query query = session.createQuery(hql);
		query.setParameter("username",uname);
		query.setParameter("password",password);
		
		
		@SuppressWarnings("unchecked")
		List<UserEntity> results = query.list();
		
		Iterator<UserEntity> it=results.iterator();	
		
		if (it.hasNext()) {
			
			return true;
		}
		else
		{
			
		return false;
		}	
	}
	
	
	public boolean checkStatus(String uname)
	{
		
		  session=HiberUtility.getSession();
		
		String hql = "FROM UserEntity where uname = :username";
		
		Query query = session.createQuery(hql);
		
		query.setParameter("username",uname);
		
		@SuppressWarnings("unchecked")
		List<UserEntity> results = query.list();	
		Iterator<UserEntity> it=results.iterator();
		UserEntity un=it.next();
		
		if (un.getstatus()==1) {
			
			return true;
		}
		else
		{
			
		return false;
		}
		
	}
	
	
	
	public boolean InsertDatabase(int uid, String uname,String password,int status)
	{
		 try{
		 session=HiberUtility.getSession();
		
		 
		 UserEntity e=new UserEntity();
		 e.setuid(uid);
		 e.setuname(uname);
		 e.setupass(password);
		 e.setstatus(status);
		 
		
		 session.save(e);	 
		 HiberUtility.closeSession(null);
		 return true;
		 
		 }
		 catch(Exception e1)
		 {
			 System.out.println("failed insert"+e1);
			 return false;
		 }
		 
		
	
	}
	
	//public static void main(String[] args) {
		
//	HiberOperations ho=new HiberOperations();
	//System.out.println(ho.InsertDatabase(2,"abhi", "abhi",0));
			//	System.out.println(ho.changeStatus("abhi",0));
	//System.out.println(ho.checkUserAndPassword("abhi","abhi"));
//System.out.println(ho.checkUser("abhi"));
		//System.out.println(ho.checkStatus("abhi"));}

}
