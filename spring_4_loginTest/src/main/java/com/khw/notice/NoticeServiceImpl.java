package com.khw.notice;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.khw.dao.NoticeDAO;
import com.khw.dto.MemberDTO;
import com.khw.dto.NoticeDTO;
import com.khw.service.BoardService;

public class NoticeServiceImpl implements BoardService {
	
	private NoticeDAO dao;
	
	
	
	public NoticeDAO getDao() {
		return dao;
	}

	public void setDao(NoticeDAO dao) {
		this.dao = dao;
	}

	@Override
	public void list(int curPage,Model model) {
		// TODO Auto-generated method stub
		ArrayList<NoticeDTO> ar = dao.listNotice(curPage);
		model.addAttribute("list", ar);
		
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
	public void view(int num,Model model) {
		// TODO Auto-generated method stub
		System.out.println("서비스 게시글 번호 : "+num);
		NoticeDTO dto = dao.viewNotice(num);
		model.addAttribute("view", dto);
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
