package com.dianyzathelli.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dianyzathelli.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	
	
	
}
