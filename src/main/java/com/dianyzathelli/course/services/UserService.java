package com.dianyzathelli.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dianyzathelli.course.entities.User;
import com.dianyzathelli.course.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired // esta anotation é para efeuar a injeção de dependencia automaticamente e associa instancia de UserRepository aqui
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
		
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
		}
	
}
