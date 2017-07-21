package com.carapp.CarApp.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.carapp.CarApp.model.Car;
import com.carapp.CarApp.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {

	@Autowired
	CarService carService;

	@GetMapping()
	public ResponseEntity<Iterable<Car>> Get() {
		Iterable<Car> response = carService.Read();
		HttpStatus status = HttpStatus.OK;

		return new ResponseEntity<Iterable<Car>>(response, status);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Car> Get(@PathVariable(value = "id") Integer vin) {
		Car response = null;
		HttpStatus status = HttpStatus.NOT_FOUND;

		if (carService.Exists(vin)) {
			response = carService.Read(vin);
			status = HttpStatus.OK;
		}

		return new ResponseEntity<Car>(response, status);
	}

	@PostMapping()
	public ResponseEntity<?> Post(@RequestBody Car car) {
		ResponseEntity<?> response = null;

		if (carService.Exists(car.Vin)) {
			response = new ResponseEntity<>(HttpStatus.CONFLICT);
		} else {
			Car result = carService.Create(car);

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.Vin)
					.toUri();

			response = ResponseEntity.created(location).build();
		}

		return response;
	}
}
