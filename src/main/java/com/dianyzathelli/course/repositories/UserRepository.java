package com.dianyzathelli.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dianyzathelli.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
	
	
}
