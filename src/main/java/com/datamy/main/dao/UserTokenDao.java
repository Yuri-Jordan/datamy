package com.datamy.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.datamy.main.connection.connectionFactory.ConnectionFactory;

public class UserTokenDao {
	
	private Connection conn;
	
	public UserTokenDao(ConnectionFactory factory) {
		this.conn = factory.getConnection();
	}
	
	public boolean saveToken(int uid, String token) {
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO user_token(user_id,token) VALUES (?,?);");
			ps.setInt(1, uid);
			ps.setString(2, token);
			return ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void close() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getToken(int userId) {
		String token = "";
		
		try {
			PreparedStatement ps = this.conn.prepareStatement(
				"SELECT token FROM user_token WHERE user_id = ?");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				token = rs.getString("token");
				
				return token;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return token;
	}
}
