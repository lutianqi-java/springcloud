package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/freemarker")
public class FreemakerController {
	/***
	 * http://127.0.0.1:8080/freemarker//showuser.html?id=1
	 * @param id
	 * @return
	 */
	@GetMapping("/showuser.html")
	public ModelAndView showUserInfo(Long id){
		ModelAndView view = new ModelAndView();
		view.setViewName("/userInfo");
		return view;
	}
	
}
