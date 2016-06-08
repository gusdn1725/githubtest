package com.khw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.khw.dto.NoticeDTO;
import com.khw.service.NoticeDaoService;
import com.khw.util.DBConnector;

@Component
public class NoticeDAO implements NoticeDaoService {

	@Inject
	private DBConnector dbConnector;
	private PreparedStatement st = null;
	private ResultSet rs = null;
	private int result = 0;
	private int perPage = 10;
	
	public void setDbConnector(DBConnector dbConnector) {
		this.dbConnector = dbConnector;
	}

	@Override
	public NoticeDTO viewNotice(int num) {
		System.out.println("dao 게시글 번호 : "+num);
		Connection con=dbConnector.getConnect();
		String sql="select * from notice where num=?";
		NoticeDTO dto = new NoticeDTO();
		try {
			st = con.prepareStatement(sql);
			st.setInt(1, num);
			
			rs=st.executeQuery();
			
			if(rs.next()){
				dto.setId(rs.getString("id"));
				dto.setTitle(rs.getString("title"));
				dto.setContents(rs.getString("contents"));
			}else{
				dto = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public ArrayList<NoticeDTO> listNotice(int curPage) {
		int start=(curPage*perPage)/perPage;
		int last=curPage*perPage;
		Connection con=dbConnector.getConnect();
		String sql="select * from "
				+ "(select rownum R,A.* from"
				+ " (select * from notice order by num desc) A) "
				+ "where R between ? and ?";
		
		ArrayList<NoticeDTO> ar=new ArrayList<>();
		
		try{
			st=con.prepareStatement(sql);
			st.setInt(1, start);
			st.setInt(2, last);
			
			rs=st.executeQuery();
			
			while(rs.next()){
				NoticeDTO dto = new NoticeDTO();
				dto.setNum(rs.getInt("num"));
				dto.setTitle(rs.getString("title"));
				dto.setReg_date(rs.getDate("reg_date"));
				dto.setId(rs.getString("id"));
				ar.add(dto);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbConnector.disConnect(rs, st, con);
		}
		
		return ar;
	}
	
	public int writeNotice(NoticeDTO dto){
		Connection con=dbConnector.getConnect();
		String sql="insert into notice values(notice_seq.nextVal,?,?,?,sysdate)";
		try {
			st=con.prepareStatement(sql);
			st.setString(1, dto.getId());
			st.setString(2, dto.getTitle());
			st.setString(3, dto.getContents());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbConnector.disConnect(st, con);
		}
		
		return result;
	}

}
