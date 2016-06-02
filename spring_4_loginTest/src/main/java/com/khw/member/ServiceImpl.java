package com.khw.member;



import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.khw.dao.MemberDAO;
import com.khw.dto.MemberDTO;
import com.khw.service.Service;

public class ServiceImpl implements Service {
	
	
	private MemberDAO dao;
	
	public MemberDAO getDao() {
		return dao;
	}

	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}

	
	/*------------------------------------------------------------------------------------------------------------------------*/
	
	@Override
	public MemberDTO login(MemberDTO dto) {
		System.out.println(dto.getId());
		dto=dao.loginCheck(dto);
		
		return dto;
	}

	@Override
	public int join(MemberDTO dto) {
		
		int result=dao.insertMember(dto);
		String path=null;
		if(result>0)
		{
			System.out.println("가입 성공");
			path="redirect:/";
		}
		else
		{
			System.out.println("가입 실패");
			path="member/join";
		}
		
		
		
		return result;

	}

	@Override
	public int update(MemberDTO memberDTO) {
		
		int result=dao.updateMember(memberDTO);
		
		return result;

	}

	@Override
	public int delete(MemberDTO memberDTO) {
		int result=dao.deleteMember(memberDTO);
		
		return result;
	}

}
