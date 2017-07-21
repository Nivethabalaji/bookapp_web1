package com.revature.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void register(UserClass user) throws Exception, Exception {

		String sql = "insert into UserClass(name,email,password )values(?,?,?)";
		Object[] params = { user.getName(), user.getEmail(), user.getPassword() };

		int rows = jdbcTemplate.update(sql, params);

		System.out.println(rows);
	}

	public UserClass login(String email, String password) throws Exception {
		// public static void main(String[] args) throws Exception {

		String sql = "select id,name,email,password from UserClass where email = ? and password = ? ";

		Object[] params = { email, password };

		UserClass userClass = null;
		try {
			userClass = jdbcTemplate.queryForObject(sql, params, (rs, rowno) -> {

				int id = rs.getInt("id");
				String name = rs.getString("name");
				String Email = rs.getString("email");
				String Password = rs.getString("password");

				UserClass user = new UserClass();
				user.setId(id);
				user.setName(name);
				user.setEmail(Email);
				user.setPassword(password);

				return user;
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return userClass;

	}
}
