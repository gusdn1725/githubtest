package com.khw.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.khw.dto.NoticeDTO;

public interface NoticeService {
	
	//리스트
	public void list(int curPage,Model model);
	//글쓰기
	public String write(NoticeDTO dto);
	//수정
	public void update();
	//삭제
	public void delete();
	//뷰
	public void view(int num,Model model);
	

}
