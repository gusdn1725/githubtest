package com.khw.service;

import com.khw.dto.MemberDTO;

public interface Service {
	//로그인
	public MemberDTO login(MemberDTO memberDTO);
	
	//회원가입
	public void join(MemberDTO memberDTO);

	//회원수정
	public void update(MemberDTO memberDTO);
	
	//회원삭제
	public void delete(MemberDTO memberDTO);
}