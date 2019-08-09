package com.ducat.springboot.rest.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.ReportAsSingleViolation;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ducat.springboot.rest.dao.MyAlienRepo;
import com.ducat.springboot.rest.model.Alien;

@Controller
public class AlienController {
	
	@Autowired
	MyAlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	@RequestMapping("/addAlien")
	public String addAliens(Alien alien) {
		
		repo.save(alien);
		return "home";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAliens(Alien alien) {
		
		
		ModelAndView mv = new ModelAndView();
		Alien alien2  = repo.findById(alien.getAid()).orElse(null);
		
		System.out.println(repo.findByAidGreaterThan(2));
		System.out.println(repo.findByAlang("Java"));
		System.out.println(repo.findByAlangSorted("Java"));
		
		mv.addObject("alien",alien2);
		mv.setViewName("showAlien");
		return mv;
	}
	@RequestMapping(path="/aliens",produces= {"application/json","application/xml"})
	@ResponseBody
	public List<Alien> getAlien() {
		
		return repo.findAll();
		
	}
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		
		return repo.findById(aid);
		
	}
	@RequestMapping("/updateAlien")
	public ModelAndView updateAlien(Alien alien) {
		
		
		ModelAndView mv = new ModelAndView();
		
		repo.save(alien);
		mv.setViewName("showAlien");
		return mv;
	}
	
	@PostMapping(path="/alien",consumes= {"application/xml","application/json"})
	@ResponseBody
	public Alien addOrUpdateAlien(@RequestBody Alien alien) {
		
		
		
		repo.save(alien);
		
		return alien;
	}
	@DeleteMapping(path="/alien/{aid}")
	@ResponseBody
	public String delAlien(@PathVariable Integer aid) {
		
		
		Alien alien = repo.getOne(aid);
		repo.delete(alien);
		
		return "Deleted";
	}
	
	
	
}
