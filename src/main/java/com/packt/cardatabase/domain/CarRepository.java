package com.packt.cardatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

	List<Car> findByBrand(String brand);
	List<Car> findByColor(String color);
	List<Car> findByYear(int year);
}
