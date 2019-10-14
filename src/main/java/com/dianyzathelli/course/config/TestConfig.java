package com.dianyzathelli.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dianyzathelli.course.entities.Order;
import com.dianyzathelli.course.entities.User;
import com.dianyzathelli.course.repositories.OrderRepository;
import com.dianyzathelli.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner { // implements a interface CommandLineRunner para executar ao iniciar programa
	
	@Autowired // esta anotation é para efeuar a injeção de dependencia automaticamente e associa instancia de UserRepository aqui
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception { // tudo que é colocado aqui é executado quando app é iniciada.
		
		//instanciando objetos da classe User com 5 atributos
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//instanciando objetos da classe Order, com 3 atributos e um deles o objeto da classe User u1 ou u2.
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		
//		OBS: Instant.parse é um novo recurso do JAVA 11 para instanciar datas, onde ele pega o horario local da maquina
//		O padrão ISO 8601 é deste formado 2019-06-20T19:53:07Z (com T e Z), qualquer lugar no mundo o desenvolvedor utiliza e sabe
//		Fica no horario de Granwitch que é 3 horas a mais do que no brasil.	
		
		userRepository.saveAll(Arrays.asList(u1, u2)); // chama userRepository passando lista de objetos para serem inseridos no BD.
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}

//CLASSE DE TESTE DE CONFIGURAÇÃO, ONDE APENAS SERÁ VALIDADO COM AS anotations @Configuration e @Profile("test")# OBS"test" é o mesmo nome
//																												#aplication.proprietes
//																												#spring.profiles.active=test