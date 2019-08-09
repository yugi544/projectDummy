package com.ducat.springboot.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ducat.springboot.rest.model.Alien;



@Controller
public class HomeController {
	@RequestMapping("home")
	public ModelAndView home(Alien alien) {
	
		ModelAndView mv = new ModelAndView();
		mv.addObject("name1",alien);
		mv.setViewName("home");
		return mv;
		//return "ji";
	}
}
