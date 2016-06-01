package com.khw.s4;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.khw.dao.MemberDAO;
import com.khw.dto.MemberDTO;
import com.khw.member.ServiceImpl;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@RequestMapping("/logout")
	public String logout(HttpSession session,RedirectAttributes redirect)
	{
		System.out.println("로그 아웃!!");
		redirect.addFlashAttribute("msg", "로그아웃 성공");
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/login", method =  RequestMethod.GET)
	public void login()
	{
		
	}
	
	@RequestMapping(value="/login", method =  RequestMethod.POST)
	public String login(@ModelAttribute MemberDTO dto,HttpSession session,RedirectAttributes redirect)
	{
		ServiceImpl si = new ServiceImpl();
		dto=si.login(dto);
		
		String path="";
		if(dto!=null)
		{
			System.out.println("로그인 성공");
			session.setAttribute("member",dto);
			redirect.addFlashAttribute("msg", "로그인 성공"); //redirect로 값을 넘겨주고 싶을때..
			path="redirect:/";
		}
		else
		{
			System.out.println("로그인 실패");
			path="member/login";
		}
		return path;
	}
	
	@RequestMapping(value="/join", method =  RequestMethod.GET)
	public void join()
	{
		
	}
	
	@RequestMapping(value="/join", method =  RequestMethod.POST)
	public String join(MemberDTO dto)
	{
		MemberDAO dao=new MemberDAO();
		int result=dao.insertMember(dto);
		String path="";
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
		
		return path;
	}
}
