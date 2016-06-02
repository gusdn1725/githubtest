package com.khw.notice;

import java.util.ArrayList;

import com.khw.dao.NoticeDAO;
import com.khw.dto.NoticeDTO;
import com.khw.service.NoticeService;

public class NoticeServiceImpl implements NoticeService {
	
	private NoticeDAO dao;
	
	
	
	public NoticeDAO getDao() {
		return dao;
	}

	public void setDao(NoticeDAO dao) {
		this.dao = dao;
	}

	@Override
	public ArrayList<NoticeDTO> list(int curPage) {
		// TODO Auto-generated method stub
		ArrayList<NoticeDTO> ar = dao.listNotice(curPage);
		
		return ar;
	}

	@Override
	public String write(NoticeDTO dto) {
		// TODO Auto-generated method stub
		int result=dao.writeNotice(dto);
		String path=null;
		if(result>0){
			System.out.println("글쓰기 성공");
			path="redirect:/notice/list?curPage=1";
		}else{
			System.out.println("글쓰기 실패");
			path="notice/write";
		}
		
		return path;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

}
