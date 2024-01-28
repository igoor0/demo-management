package dev.cafemanagement.server;

import dev.cafemanagement.server.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication   {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}