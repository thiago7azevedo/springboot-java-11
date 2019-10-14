package com.dianyzathelli.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dianyzathelli.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

		
	
}
