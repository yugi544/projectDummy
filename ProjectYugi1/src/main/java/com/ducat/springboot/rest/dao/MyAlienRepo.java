package com.ducat.springboot.rest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ducat.springboot.rest.model.Alien;

public interface MyAlienRepo extends JpaRepository<Alien, Integer> {
	
	List<Alien> findByAlang(String alang);
	List<Alien> findByAidGreaterThan(int aid);
	@Query("from Alien a where a.alang=?1 order by a.aname desc")
    List<Alien> findByAlangSorted(String alang);

}
