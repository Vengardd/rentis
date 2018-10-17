package com.vengard.rentis.controller;

import com.vengard.rentis.exception.CarNotFoundException;
import com.vengard.rentis.service.CarService;
import com.vengard.rentis.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/car/all")
    public List<Car> allCars() {
        return carService.getAllCars();
    }

    @GetMapping("/car/{id}")
    public Car findCarById(@PathVariable Long id) throws CarNotFoundException {
        return carService.findById(id);
    }

    @PostMapping("/car/add")
    public ResponseEntity addCar(@RequestBody Car car) {
        return ResponseEntity.ok(carService.addCar(car));
    }


}
