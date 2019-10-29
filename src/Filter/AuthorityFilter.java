package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
/*编写过滤器实现类的程序*/
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorityFilter implements Filter{

	
	
	public void destroy(){}
	
	
	
	
	
	public void doFilter(ServletRequest arg0,ServletResponse arg1,FilterChain arg2)throws IOException,ServletException{
		//你的权限是什么？
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		HttpSession session=request.getSession();
		Integer _super=(Integer)session.getAttribute("_super");
		System.out.println("AuthorityFilter  :    "+_super);
		//根据你的权限，你可以访问相应的页面，否则就去权限错误的页面
		if(_super!=null){
		if(_super==0)
			response.sendRedirect(request.getContextPath()+"/index.html");
		else
			if(_super!=1)
				response.sendRedirect(request.getContextPath()+"/authority.html");
			else
				arg2.doFilter(arg0,arg1);
		}else
			response.sendRedirect(request.getContextPath()+"/index.html");
	
	}
	public void init(FilterConfig arg0) throws ServletException{
		
	}
}
