package com.khw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.khw.dto.MemberDTO;
import com.khw.util.DBConnector;


@Repository //객체 생성 어노테이션
public class MemberDAO {
	
	@Inject
	private DBConnector dbConnector;
	
	private int result=0;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	
	public int idCheck(String id)
	{
		System.out.println("dao"+id);
		Connection con = dbConnector.getConnect();
		String sql = "select * from member where id=?";
		try {
			st = con.prepareStatement(sql);
			st.setString(1, id);
			
			rs = st.executeQuery();
			if(rs.next()){
				result = 1;
			}else{
				result = 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbConnector.disConnect(rs, st, con);
		}
		
		return result;
	}
	
	public MemberDTO loginCheck(MemberDTO dto)
	{	System.out.println(dto.getId());
		Connection con=dbConnector.getConnect();
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
			dbConnector.disConnect(rs, st, con);
		}
		
		return dto;
	}
	
	public int insertMember(MemberDTO dto)
	{
		Connection con=dbConnector.getConnect();
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
			dbConnector.disConnect(st, con);
		}
		
		return result;
	}
	
	public int updateMember(MemberDTO dto)
	{
		Connection con=dbConnector.getConnect();
		String sql = "update member set name=?, age=? where id=?";
		try
		{
			st=con.prepareStatement(sql);
			st.setString(1, dto.getName());
			st.setInt(2, dto.getAge());
			st.setString(3, dto.getId());
			
			result=st.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			dbConnector.disConnect(st, con);
		}
		
		return result;
	}
	
	public int deleteMember(MemberDTO dto)
	{
		Connection con = dbConnector.getConnect();
		String sql = "delete member where id=? and pw=?";
		try 
		{
			st = con.prepareStatement(sql);
			st.setString(1, dto.getId());
			st.setString(2, dto.getPw());
			result=st.executeUpdate();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			dbConnector.disConnect(st, con);
		}
		
		return result;
	}

}
