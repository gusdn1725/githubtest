package com.khw.service;

import java.util.ArrayList;

import com.khw.dto.NoticeDTO;

public interface NoticeService {
	
	//리스트
	public ArrayList<NoticeDTO> list(int curPage);
	//글쓰기
	public String write(NoticeDTO dto);
	//수정
	public void update();
	//삭제
	public void delete();
	
	

}
