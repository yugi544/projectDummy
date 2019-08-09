package com.ducat.springboot.rest.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ducat.springboot.rest.model.Todos;

public interface MyTodoRepo extends JpaRepository<Todos, Integer>{

}
