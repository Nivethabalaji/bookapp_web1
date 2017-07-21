package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.com.Book;
import com.revature.com.BookOrder;
import com.revature.com.BookorderDAo;


@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
  		out.println("OrderServlet");
  		String userClassId=request.getParameter("userid");
  		String bookId=request.getParameter("bookid");
  		String quantity=request.getParameter("quantity");
  		
  		System.out.println("UserId= " + userClassId +", BookId=" + bookId + ", quantity=" + quantity);
  		int p=Integer.parseInt(quantity);
  		int q=Integer.parseInt(userClassId);
  		int r=Integer.parseInt(bookId);
  		
  		
  		
  		BookOrder order=new BookOrder();
  		
  		order.setUserClassId(q);
  		order.setQuantity(p);
  		order.setBookId(r);
  		order.setStatus("ordered");
  		out.println("order" + order);
  		
  		
  		
  		
  		BookorderDAo orderDAO=new BookorderDAo();
  		try {
			orderDAO.register(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		
  		response.sendRedirect("Listorder.jsp");

	}

}
