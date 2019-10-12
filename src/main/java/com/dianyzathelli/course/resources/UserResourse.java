package com.dianyzathelli.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dianyzathelli.course.entities.User;

@RestController
@RequestMapping(value = "/users") // correspnde ao caminho de resposta, através da anotation @RequestMapping
public class UserResourse {
	
	@GetMapping // anotation GetMapping dizendo que o método ResponseEntity para indicar o tipo get do HTTP
	public ResponseEntity<User>	findAll() {
		User u = new User(1L, "Maria", "maria@gmail.com", "48999347778", "12345");
		return ResponseEntity.ok().body(u); // retorna o método e se é ok, com o cortpo do objeto criado (body).
	}
}

// CONTROLADOR REST, QUE RESPONDE NO CAMINHO /users

