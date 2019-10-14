package com.dianyzathelli.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dianyzathelli.course.entities.Category;
import com.dianyzathelli.course.repositories.CategoryRepository;


@Service
public class CategoryService {
	
	@Autowired // esta anotation é para efeuar a injeção de dependencia automaticamente e associa instancia de CategoryRepository aqui
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
		
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
		}
	
}
