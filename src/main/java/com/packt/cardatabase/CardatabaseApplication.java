package com.packt.cardatabase;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;
import com.packt.cardatabase.domain.User;
import com.packt.cardatabase.domain.UserRepository;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	@Autowired
	private CarRepository repository;
	@Autowired
	private OwnerRepository ownerRepository;
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner("John", "Johnson");
		Owner owner2 = new Owner("Mary", "Robinson");
		ownerRepository.saveAll(List.of(owner1, owner2));

		repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000, owner1));
		repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000, owner2));
		repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2020, 39000, owner2));

		for (Car car : repository.findAll()) {
			logger.info(car.getBrand() + " " + car.getModel());
		}

		userRepository.save(new User("user", "$2a$10$Eqw4tjyRhukLV7DcrnLn0ujyEaST0J5dtOmkqUB/lXG537KNRsWIi", "USER"));
		userRepository.save(new User("admin", "$2a$10$ctvo70LP7QtNeFyX3uJ0Aen90twWZIMgElIPuGex0l54EeuH7DJQi", "ADMIN"));
	}
}
