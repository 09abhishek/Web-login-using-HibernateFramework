package control;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class InvoiceTag extends TagSupport {

	@Override
	public int doEndTag() throws JspException {
		 JspWriter out=pageContext.getOut();
		 
		 HttpSession session=pageContext.getSession();
		 
		 Enumeration e=session.getAttributeNames();
			while(e.hasMoreElements()){
				String attributename=e.nextElement().toString();
				String attributevalue=session.getAttribute(attributename).toString();
				if(attributename.equals("rb") || attributename.equals("shopid") || attributename.equals("id")){}
				else{
				try {
					out.println("<h1>"+attributename+":"+attributevalue+"</h1>");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		
		return 1;
	}
}
