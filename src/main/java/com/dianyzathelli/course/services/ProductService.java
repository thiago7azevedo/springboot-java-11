package com.dianyzathelli.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dianyzathelli.course.entities.Product;
import com.dianyzathelli.course.repositories.ProductRepository;


@Service
public class ProductService {
	
	@Autowired // esta anotation é para efeuar a injeção de dependencia automaticamente e associa instancia de ProductRepository aqui
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
		
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
		}
	
}
