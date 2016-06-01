package com.khw.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector {

	private static String user="user04";
	private static String password="user04";
	private static String url="jdbc:oracle:thin:@localhost:1521:xe";
	private static String driver="oracle.jdbc.driver.OracleDriver";
	
	public static Connection getConnect(){
		Connection con=null;
		try {
			Class.forName(driver);
			con= DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void disConnect(ResultSet rs,PreparedStatement st,Connection con){
		try {
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void disConnect(PreparedStatement st,Connection con){
		try {
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
