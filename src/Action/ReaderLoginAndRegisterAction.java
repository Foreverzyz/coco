package Action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Dao.ReaderLoginAndRegisterDao;

public class ReaderLoginAndRegisterAction extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		ReaderLoginAndRegisterDao rlr=new ReaderLoginAndRegisterDao();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username + "  " + password);
		resp.getWriter().write("hello");
		int status=rlr.loginbyidandpsw(username, password);
		HttpSession session=req.getSession();
		session.setAttribute("status", status);
		if(status==1)
			resp.sendRedirect(req.getContextPath()+"/reader/readerself.jsp");
		else
			resp.sendRedirect(req.getContextPath()+"/reader/error.html");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
