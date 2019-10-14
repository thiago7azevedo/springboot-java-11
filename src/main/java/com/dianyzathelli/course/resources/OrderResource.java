package com.dianyzathelli.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dianyzathelli.course.entities.Order;
import com.dianyzathelli.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders") // correspnde ao caminho de resposta, através da anotation @RequestMapping
public class OrderResource {
	
	@Autowired // importa todas as dependencias
	private OrderService service;
	
	@GetMapping // anotation GetMapping dizendo que o método ResponseEntity para indicar o tipo get do HTTP
	public ResponseEntity <List<Order>> findAll() {
		List<Order> list = service.findAll();		
		return ResponseEntity.ok().body(list); // retorna o método e se é ok, com o cortpo do objeto criado (body).
	}
	
	@GetMapping(value = "/{id}") // passa o valor do ID no mapping
	public ResponseEntity<Order> findById(@PathVariable Long id){ // ResponseEntity somente de Order, pois não retorna lista e sim ID
		Order obj = service.findById(id); //considera como parametro o ID que vai chegar atraves do @PathVariable 
		return ResponseEntity.ok().body(obj);
	}
}

// CONTROLADOR REST, QUE RESPONDE NO CAMINHO /users
 
