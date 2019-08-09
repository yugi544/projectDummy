package com.ducat.springboot.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.springboot.rest.dao.MyTodoRepo;
import com.ducat.springboot.rest.model.Todos;
@CrossOrigin(value="*")
@RestController
public class TodosController {
	@Autowired
	MyTodoRepo repo;

	@RequestMapping(value="/todos/getAll",method= RequestMethod.GET,produces="application/json")
	@ResponseBody
	public List<Todos> getAllTodos() {
		List<Todos> todos	=repo.findAll();
		
		return todos;
	}
	@RequestMapping(value="/todos/add",method= RequestMethod.POST)
	@ResponseBody
	public Todos addTodo(@RequestBody Todos todo) {
		
		  todo = repo.save(todo);
		
		return todo;
	}
	@RequestMapping(value="/todos/{id}",method= RequestMethod.PUT)
	@ResponseBody
	public Todos upDateTodo(@PathVariable int id,@RequestBody Todos todo1) {
		
		
		Optional<Todos> todo	= repo.findById(id);
		  if(todo1.getTitle() ==null || todo1.getTitle().isEmpty()) {
			  todo1.setTitle(todo.get().getTitle());
		  }
		  todo1.setId(todo.get().getId());
		
		return repo.save(todo1);
	}
	@RequestMapping(value = "/todos/delete/{id}",method=RequestMethod.DELETE ) 
	public void deleteTodo(@PathVariable int id) throws Exception {
		
		Optional<Todos> todoOp = repo.findById(id);
		if(!todoOp.isPresent()) {
			throw new Exception("Could not find employee with id - " +id);
		}
		
		repo.deleteById(id);
		
		
	}
}
