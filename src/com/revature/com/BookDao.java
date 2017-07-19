package com.revature.com;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;





public class BookDao {
	public void register (Book book)throws Exception{
		 LocalDate p=LocalDate.parse("2014-05-10");
		 
		Connection con=ConnectionUtil.getConnection();
		String sql="insert into book(name,price,publisheddate )values(?,?,?)";
		PreparedStatement pst= con.prepareStatement(sql);
		pst.setString(1,book.getName());
		pst.setInt(2,book.getPrice());
		pst.setDate(3,Date.valueOf(p));
		
		int rows=pst.executeUpdate();
				
			System.out.println(rows);
		
	}
	//public static void main(String[] args) throws Exception {
	public List<Book> listBooks() throws Exception{
	
		Connection con=ConnectionUtil.getConnection();
		String sql="select id,name,price,publisheddate from Book";
		PreparedStatement pst=con.prepareStatement(sql);
		List<Book>bookList=new ArrayList<Book>();
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			int id=rs.getInt("id");
			String name=rs.getString("name");
			int price=rs.getInt("price");
			Date publishedDate=rs.getDate("publisheddate");
			Book b=new Book();
			b.setId(id);
			b.setName(name);
			b.setPrice(price);
			b.setDate(publishedDate.toLocalDate());
			bookList.add(b);
			
		}
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
