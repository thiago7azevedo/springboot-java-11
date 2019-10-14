package com.dianyzathelli.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dianyzathelli.course.entities.Order;
import com.dianyzathelli.course.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired // esta anotation é para efeuar a injeção de dependencia automaticamente e
				// associa instancia de OrderRepository aqui
	private OrderRepository repository;

	public List<Order> findAll() {
		return repository.findAll();

	}

	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}

}
