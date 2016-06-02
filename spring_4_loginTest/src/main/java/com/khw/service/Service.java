package com.khw.service;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.khw.dto.MemberDTO;

public interface Service {
	//로그인
	public MemberDTO login(MemberDTO memberDTO);
	
	//회원가입
	public int join(MemberDTO memberDTO);

	//회원수정
	public int update(MemberDTO memberDTO);
	
	//회원삭제
	public int delete(MemberDTO memberDTO);
}