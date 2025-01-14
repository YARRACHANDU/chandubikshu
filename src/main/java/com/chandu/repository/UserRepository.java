package com.chandu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chandu.entity.Welcome;
@Repository
public interface UserRepository  extends JpaRepository<Welcome,Integer>{

	Welcome findByUsername(String username);

	

}
