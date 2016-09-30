package control;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {

    public SessionFilter() {

    }

	public void destroy() {
	System.out.println(" filter destroyed");	
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		System.out.println("Filter");
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
	HttpSession session=req.getSession();
	if(session.isNew())
	{
		String name=request.getParameter("id").toString();
		if(name.equals("language"))
		{
		
		chain.doFilter(req, res);
		}
		else
		{
			res.sendRedirect("expire.jsp");
		}}
	else
		
	{		
		
		chain.doFilter(request, response);
		
	}
		
		System.out.println("The filter is executed");	
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println();	
	
	}

}