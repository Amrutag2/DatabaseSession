package org.mypack.servlet;
import org.mypack.dao.UserDao;
import org.mypack.dao.UserDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private static UserDao userDao = new UserDaoImpl();
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");	
		String password = request.getParameter("password");	
		if(userDao.isValidUser(username, password)) {
			HttpSession session = request.getSession();
//			System.out.println("sessionn created");
			session.setAttribute("username", username);
//			System.out.println("redirect to welcome");
			response.sendRedirect("welcome.jsp");	
		}else {
			response.sendRedirect("login.jsp?error=1");
			System.out.println("Error to login");
		}
	}

}
