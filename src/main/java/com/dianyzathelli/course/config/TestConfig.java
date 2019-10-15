package com.dianyzathelli.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dianyzathelli.course.entities.Category;
import com.dianyzathelli.course.entities.Order;
import com.dianyzathelli.course.entities.OrderItem;
import com.dianyzathelli.course.entities.Payment;
import com.dianyzathelli.course.entities.Product;
import com.dianyzathelli.course.entities.User;
import com.dianyzathelli.course.entities.enums.OrderStatus;
import com.dianyzathelli.course.repositories.CategoryRepository;
import com.dianyzathelli.course.repositories.OrderItemRepository;
import com.dianyzathelli.course.repositories.OrderRepository;
import com.dianyzathelli.course.repositories.ProductRepository;
import com.dianyzathelli.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner { // implements a interface CommandLineRunner para executar ao iniciar programa
	
	@Autowired // esta anotation é para efeuar a injeção de dependencia automaticamente e associa instancia de UserRepository aqui
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productrepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception { // tudo que é colocado aqui é executado quando app é iniciada.
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));// salva no BD
		productrepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
//		Assossiação entre os objetos para a tabela relacional do H2		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productrepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5)); 
		
		//instanciando objetos da classe User com 5 atributos
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//instanciando objetos da classe Order, com 3 atributos e um deles o objeto da classe User u1 ou u2.
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
//		OBS: Instant.parse é um novo recurso do JAVA 11 para instanciar datas, onde ele pega o horario local da maquina
//		O padrão ISO 8601 é deste formado 2019-06-20T19:53:07Z (com T e Z), qualquer lugar no mundo o desenvolvedor utiliza e sabe
//		Fica no horario de Granwitch que é 3 horas a mais do que no brasil.	
		
		userRepository.saveAll(Arrays.asList(u1, u2)); // chama userRepository passando lista de objetos para serem inseridos no BD.
		orderRepository.saveAll(Arrays.asList(o1, o2, o3)); // salva no BD
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);
//		Neste caso de mão dupla ou um para um (OneToOne) não chama o repository para salvar
//		adiciona na order o pagamento e chama o save de orderRepository, que o JPA vai salvar no BD
		orderRepository.save(o1);
	}
}

//CLASSE DE TESTE DE CONFIGURAÇÃO, ONDE APENAS SERÁ VALIDADO COM AS anotations @Configuration e @Profile("test")# OBS"test" é o mesmo nome
//																												#aplication.proprietes
//																												#spring.profiles.active=test