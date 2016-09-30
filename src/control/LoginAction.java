package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import priyatravels.HiberOperations;

public class LoginAction extends Action{
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	
	HttpSession session=request.getSession();
	String uname=request.getParameter("uname").toString();
	String pass=request.getParameter("upass");
	System.out.println("hereeeeeeeeeeeeeeeeeeeeeeeeee"+uname);
	
	HiberOperations h=new HiberOperations();
		
		if(h.checkUserAndPassword(uname, pass))
		{
			if(!h.checkStatus(uname)){
				
				h.changeStatus(uname, 1);
				session.setAttribute("username",uname);
				return "login.success";
			}
			else
			{
				System.out.println("Already ur Logged In check the status in db 0/1 ");
				return "login.already";
			}
			
		}
		
		else
		{
			if(h.checkUser(uname))
			{
				System.out.println("incorrect password");
				return "login.failure";
			}
		   else
			{
				System.out.println("user does not exist");
				return "login.failure";

			}
		}
}
}