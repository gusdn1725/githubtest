package com.khw.s4;


import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.khw.dao.MemberDAO;
import com.khw.dto.MemberDTO;
import com.khw.member.ServiceImpl;
import com.khw.service.Service;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	
	private Service si;
	
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
		System.out.println("서비스 객체 "+si);
		String path=null;
		dto=si.login(dto);
		if(dto!=null)
		{
			System.out.println("로그인 성공");
			session.setAttribute("member",dto);
			redirect.addFlashAttribute("msg", "로그인 성공");
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
		int result=si.join(dto);
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
		
		
		return path;
	}
	
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public void update()
	{
		
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(MemberDTO dto,HttpSession session)
	{
		int result = si.update(dto);
		
		if(result>0)
		{
			session.setAttribute("member", dto);
			System.out.println("업데이트 성공");
			return "redirect:/";
		}else{
			System.out.println("업데이트 실패");
			return "member/update";
		}
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public void delete()
	{
		
	}
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String delete(MemberDTO dto,HttpSession session)
	{
		int result = si.delete(dto);
		
		if(result>0)
		{
			session.invalidate();
			System.out.println("삭제 성공");
			return "redirect:/";
		}else{
			System.out.println("삭제 실패");
			return "member/delete";
		}
	}
	@RequestMapping(value = "/idcheck", method = RequestMethod.POST)
	@ResponseBody
	public String idCheck(String id){
		System.out.println("컨트롤러 "+id);
		String msg = si.idCheck(id);
		
		return msg;
		
	}
}
