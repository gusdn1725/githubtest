package com.khw.s4;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.khw.dto.NoticeDTO;
import com.khw.service.NoticeService;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Inject
	NoticeService ns;
	
	@RequestMapping(value="/list" , method = RequestMethod.GET)
	public void list(@RequestParam("curPage") int curPage,Model model){
		ns.list(curPage,model);
	}
	
	@RequestMapping(value="/write" , method = RequestMethod.GET)
	public void write(){
		
	}
	
	@RequestMapping(value="/write" , method = RequestMethod.POST)
	public String write(NoticeDTO dto){
		String path=ns.write(dto);
		return path;
	}
	
	@RequestMapping(value="/view" , method = RequestMethod.GET)
	public void view(@RequestParam("num")int num,Model model){
		System.out.println("게시글 번호 : "+num);
		ns.view(num,model);
	}

}
