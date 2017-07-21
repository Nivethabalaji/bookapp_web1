package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.com.UserClass;
import com.revature.com.UserDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	   
    public LoginServlet(){
    }
    
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		UserClass user=null;
		out.println("LoginServlet");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		
		 UserDao UserDAO= new UserDao();
		 try {
			user=UserDAO.login(email,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 out.println(user);
		 if(user==null)
		 {
			 request.setAttribute("errormessage","invalid login");

			 RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
			 dispatcher.forward(request,response );

		 }
		 else
		 {
			 HttpSession session=request.getSession();
			 session.setAttribute("Logged_in_user",user);
			 response.sendRedirect("listbooks.jsp");
		 }
		
				
		
	}

	

}
