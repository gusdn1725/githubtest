package com.khw.service;

import java.util.ArrayList;

import com.khw.dto.NoticeDTO;

public interface NoticeDaoService {
	
	public ArrayList<NoticeDTO> listNotice(int curPage);
	
	public int writeNotice(NoticeDTO dto);

}
