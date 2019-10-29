package Action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.BookDao;
import Dao.ReaderLoginAndRegisterDao;
import Dao.ReaderSelfDao;
import Entity.Book;

public class ReaderSelfAction extends HttpServlet{
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	
		String action = request.getParameter("action");
		if (action.equals("getall")) {
			this.getAll(request, response);
		} 
		else if(action.equals("exit")) {
			this.readerexit(request, response);
		} 
		

	}

	private void getAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReaderSelfDao bdao = new ReaderSelfDao();
		ArrayList<Book> bookArrayList = bdao.getAllBook();
		HttpSession session = request.getSession();
		session.setAttribute("booklist", bookArrayList);
		System.out.print("vvvvvv");
		request.getRequestDispatcher("/reader/book.jsp")
				.forward(request, response);
	}
	private void readerexit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/reader/index.jsp")
				.forward(request, response);
	}
	
}
