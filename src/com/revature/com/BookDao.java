package com.revature.com;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;





public class BookDao {
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	public void register (Book book)throws Exception{
		 LocalDate p=LocalDate.parse("2014-05-10");
		 
		
		String sql="insert into book(name,price,publisheddate )values(?,?,?)";
		Object[] params={book.getName(),book.getPrice(),book.getDate()};
		
		int rows=jdbcTemplate.update(sql,params);
				
			System.out.println(rows);
		
	}
//public static void main(String[] args) throws Exception {
	public List<Book> listBooks() throws Exception{
			JdbcTemplate con=ConnectionUtil.getJdbcTemplate();
		
		String sql="select id,name,price,publisheddate from book";
		List<Book>bookList =jdbcTemplate.query(sql,(rs,rowNo)->{
		
	
	
			int id=rs.getInt("id");
			String name=rs.getString("name");
			int price=rs.getInt("price");
			Date publishedDate=rs.getDate("publisheddate");
			Book b=new Book();
			b.setId(id);
			b.setName(name);
			b.setPrice(price);
			b.setDate(publishedDate.toLocalDate());
			return b;
			
		});
		System.out.println(bookList);
		return bookList;
		//for(Book b:bookList)
		//{
			//System.out.println(b);
		//}
		
		
		
		
		
		
	}
	public List<Book> login() {
		// TODO Auto-generated method stub
		return null;
	}

}
