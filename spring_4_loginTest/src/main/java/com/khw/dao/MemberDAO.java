package com.khw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.khw.dto.MemberDTO;
import com.khw.util.DBConnector;

public class MemberDAO {
	
	private int result=0;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	
	public MemberDTO loginCheck(MemberDTO dto)
	{
		Connection con=DBConnector.getConnect();
		String sql="select * from member where id=? and pw=?";
		try 
		{
			st=con.prepareStatement(sql);
			st.setString(1, dto.getId());
			st.setString(2, dto.getPw());
			
			rs=st.executeQuery();
			if(rs.next())
			{
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
			}
			else
			{
				dto=null;
			}
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBConnector.disConnect(rs, st, con);
		}
		
		return dto;
	}
	
	public int insertMember(MemberDTO dto)
	{
		Connection con=DBConnector.getConnect();
		String sql="insert into member values(?,?,?,?)";
		try 
		{
			st=con.prepareStatement(sql);
			st.setString(1, dto.getId());
			st.setString(2, dto.getPw());
			st.setString(3, dto.getName());
			st.setInt(4, dto.getAge());
			
			result=st.executeUpdate();
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBConnector.disConnect(st, con);
		}
		
		return result;
	}

}
