package com.example.demo;

import com.example.demo.models.Client;
import com.example.demo.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	CommandLineRunner init(ClientRepository clientRepository){
		return args -> {
			Client client1 = new Client("Eduardo","Mendoza","eduardo@mail.com",passwordEncoder.encode("123456"));
			Client client2 = new Client("Juan","Perez","juan@mail.com",passwordEncoder.encode("123456"));
			Client client3 = new Client("Maria","Lopez","maria@mail.com",passwordEncoder.encode("123456"));
			Client client4 = new Client("Pedro","Gomez","pedro@mail.com",passwordEncoder.encode("123456"));

			clientRepository.saveAll(List.of(client1,client2,client3,client4));
		};
	}

}
