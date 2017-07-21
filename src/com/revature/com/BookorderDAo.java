package com.revature.com;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class BookorderDAo {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void register (BookOrder order)throws Exception{
		String sql="insert into Bookorders(UserClass_id,book_id,status,quantity,Order_date)values(?,?,?,?,?)";
		Object[] params={order.getUserClassId(),order.getBookId(),order.getStatus(),order.getQuantity(),order.getOrderDate()};
		
		int rows=jdbcTemplate.update(sql,params);
		System.out.println(rows);
	

}
	//public static void main(String[] args)throws Exception {
		
	
	public List<BookOrder> login() throws Exception {
	
		String sql="select id,UserClass_id,book_id,status,quantity,Order_date from Bookorders ";
		
		List<BookOrder>orderList =jdbcTemplate.query(sql,(rs,rowNo)->{
			int Id=rs.getInt("id");
			int userclassId=rs.getInt("userClass_id");
			int bookId=rs.getInt("book_id");
			String status=rs.getString("status");
			int quantity =rs.getInt("quantity");
			Timestamp order_date=rs.getTimestamp("order_date");
			BookOrder order=new BookOrder();
			order.setId(Id);
			order.setBookId(bookId);
			order.setUserClassId(userclassId);
			order.setQuantity(quantity);
			order.setStatus(status);
			order.setOrderDate(order_date.toLocalDateTime());
			return order;
			
			
			
			
			
			
		});
		System.out.println(orderList);
		
		return orderList;
		
	
		
		
		
		
	}
	}




