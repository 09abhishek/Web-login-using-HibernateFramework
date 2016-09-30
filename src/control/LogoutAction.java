package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import priyatravels.HiberOperations;

public class LogoutAction extends Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		
		String uname=session.getAttribute("username").toString();
		
		
		HiberOperations h=new HiberOperations();
		
		System.out.println("In Logout Action:"+uname);
		
	if(h.checkUser(uname))
	{
			System.out.println(h.changeStatus(uname,0));
			
			session.invalidate();
		
			System.out.println("Status change success logout success");
			
			return "logout.success";	}
	else
	{
		System.out.println("Logout Failed");
		
			return "logout.failure";
		}
		
		
	}
}