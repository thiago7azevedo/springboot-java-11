package com.dianyzathelli.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dianyzathelli.course.entities.User;
import com.dianyzathelli.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner { // implements a interface CommandLineRunner para executar ao iniciar programa
	
	@Autowired // esta anotation é para efeuar a injeção de dependencia automaticamente e associa instancia de UserRepository aqui
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception { // tudo que é colocado aqui é executado quando app é iniciada.
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2)); // chama userRepository passando lista de objetos para serem inseridos no BD.
	}

	
}

//CLASSE DE TESTE DE CONFIGURAÇÃO, ONDE APENAS SERÁ VALIDADO COM AS anotations @Configuration e @Profile("test")# OBS"test" é o mesmo nome
//																												#aplication.proprietes
//																												#spring.profiles.active=test