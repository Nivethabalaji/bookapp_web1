package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.com.Book;
import com.revature.com.BookDao;
import java.lang.NumberFormatException;

@WebServlet("/AddBookservlet")
public class AddBookservlet extends HttpServlet {
	
       
    public AddBookservlet() {
    }
    
    
      	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      		PrintWriter out=response.getWriter();
      		out.println("AddBookservlet");
      	
      		String name=request.getParameter("name");
      		String price=request.getParameter("price");
          	String publisheddate=request.getParameter("publisheddate");

      		int p=Integer.parseInt(price);
      		
      		LocalDate d=LocalDate.parse(publisheddate);
      	out.println("name,price,publisheddate");
      		Book book=new Book();
      		book.setName(name);
      		book.setPrice(p);
      		book.setPublisheddate(d);
      		out.println(book);
      		 BookDao bookDAO = new BookDao();
      		 try {
				bookDAO.register(book);
			} catch (Exception e) {
				 //TODO Auto-generated catch block
				e.printStackTrace();
			}
      		 response.sendRedirect("addbook.jsp");
      		 
      		
      		
      		
      		
      		
		}

	
}
