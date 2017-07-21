package com.carapp.CarApp.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carapp.CarApp.model.Car;
import com.carapp.CarApp.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	DataSource dataSource;

	@Autowired
	CarRepository carRepository;

	public Iterable<Car> Read() {
		return carRepository.findAll();
	}

	public Car Read(int vin) {
		return carRepository.findOne(vin);
	}

	public Car Create(Car car) {
		return carRepository.save(car);
	}

	public void Delete(int id) {

	}
	
	public boolean Exists(Integer vin)
	{
		return carRepository.exists(vin);
	}
}
