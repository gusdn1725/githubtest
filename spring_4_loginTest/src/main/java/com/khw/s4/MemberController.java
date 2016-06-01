package com.khw.s4;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.khw.dao.MemberDAO;
import com.khw.dto.MemberDTO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		System.out.println("로그 아웃!!");
		HttpSession session=request.getSession();
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/login", method =  RequestMethod.GET)
	public void login(){
		
	}
	
	@RequestMapping(value="/login", method =  RequestMethod.POST)
	public String login(MemberDTO dto,HttpServletRequest request){
		MemberDAO dao=new MemberDAO();
		dto=dao.loginCheck(dto);
		String path="";
		if(dto!=null){
			System.out.println("로그인 성공");
			HttpSession session=request.getSession();
			System.out.println(dto.getId());
			System.out.println(dto.getName());
			session.setAttribute("member",dto);
			path="redirect:/";
		}else{
			System.out.println("로그인 실패");
			path="/member/login";
		}
		return path;
	}
	
	@RequestMapping(value="/join", method =  RequestMethod.GET)
	public void join(){
		
	}
	
	@RequestMapping(value="/join", method =  RequestMethod.POST)
	public String join(MemberDTO dto){
		MemberDAO dao=new MemberDAO();
		int result=dao.insertMember(dto);
		String path="";
		if(result>0){
			System.out.println("가입 성공");
			path="redirect:/";
		}else{
			System.out.println("가입 실패");
			path="/member/join";
		}
		
		return path;
	}
}
