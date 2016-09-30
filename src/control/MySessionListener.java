package control;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import priyatravels.HiberOperations;

public class MySessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent event)  { 
    HttpSession session=event.getSession();
    System.out.println("Session is created"+session.isNew());       	
    }
        
    public void sessionDestroyed(HttpSessionEvent event)  { 

 
    	System.out.println("session destroyed");
    	HiberOperations h=new HiberOperations();
    	HttpSession session=event.getSession();
    	Object uname=session.getAttribute("uname");
    	if(uname!=null)
    	{
    		h.changeStatus(uname.toString(), 0);
    		 System.out.println("session is expired and logout is success");
    			
    	System.out.println("Session is destroyed!");
    	
    	
    	}	
    }
	
    }
