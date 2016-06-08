package com.khw.member;




import javax.inject.Inject;
import com.khw.dao.MemberDAO;
import com.khw.dto.MemberDTO;
import com.khw.service.Service;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
	
	@Inject
	private MemberDAO dao;
	
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
	
	@Override
	public String idCheck(String id) {
		System.out.println("서비스 "+id);
		int result = dao.idCheck(id);
		
		if(result==1){
			return "이미 있는 아이디 입니다.";
		}else{
			return "사용가능한 아이디 입니다";
		}
		
	}

}
