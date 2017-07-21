package com.carapp.CarApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.carapp.CarApp.model.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {

}
