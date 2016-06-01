package com.khw.member;

import com.khw.dao.MemberDAO;
import com.khw.dto.MemberDTO;
import com.khw.service.Service;

public class ServiceImpl implements Service {

	@Override
	public MemberDTO login(MemberDTO dto) {
		MemberDAO dao=new MemberDAO();
		dto=dao.loginCheck(dto);
		return dto;
	}

	@Override
	public void join(MemberDTO memberDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(MemberDTO memberDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(MemberDTO memberDTO) {
		// TODO Auto-generated method stub

	}

}
