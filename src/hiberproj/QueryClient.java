package hiberproj;

import java.util.Iterator;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;

public class QueryClient {
	
	public static void main(String args[])throws Exception

	{
		Session session=HiberUtility.getSession();
			
		String query="from UserEntity";
	//Query queryresult=session.createQuery(query);
		
		Query queryresult=session.getNamedQuery("findAll");
		
		
		
	List<UserEntity> list=queryresult.list();
	
	Iterator<UserEntity> iter=list.iterator();

		while(iter.hasNext())
	{
	UserEntity user=iter.next();
	System.out.println(user.getuid()+":"+user.getuname()+":"+user.getupass());
	}

	}
	}


