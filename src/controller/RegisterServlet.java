package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.com.UserClass;
import com.revature.com.UserDao;



@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("RegisterServlet");
		String name=request.getParameter("name");
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		 UserClass user=new UserClass();
		 
		 user.setName(name);
		 user.setEmail(email);
		 user.setPassword(password);
		 out.println("user="+user);
		
		
		 
		 UserDao UserDAO= new UserDao();
		 try {
			UserDAO.register(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 response.sendRedirect("login.jsp");
		
		
		
	}

	

}
