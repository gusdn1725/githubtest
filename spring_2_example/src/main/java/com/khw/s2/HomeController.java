package com.khw.s2;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping("member/join")
	public void join(){
	
	}
	@RequestMapping("member/joinProcess")
	public String joinProcess(@ModelAttribute MemberDTO mdto){
		//파라미터 이름과 매개변수 이름을 같게해주면 써줄 필요 없음 
		//dto에 선언된 파라미터 이름과 같아야함... 
		//dto의 멤버변수는 private이며 get,set이 존재해애함. and 기본생성자가 있어야함
	/*	MemberDTO mdto= new MemberDTO();
		mdto.setId(request.getParameter("id"));
		mdto.setPw(request.getParameter("pw"));
		mdto.setAge(age);*/
		System.out.println("아이디 : "+mdto.getId()+"\n 비밀번호 : "+mdto.getPw()+"\n 나이 : "+mdto.getAge());
		return "redirect:/";
	}
	
}
