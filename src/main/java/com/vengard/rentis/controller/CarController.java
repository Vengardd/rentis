package com.vengard.rentis.controller;

import com.vengard.rentis.service.CarService;
import com.vengard.rentis.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/car/all")
    public ResponseEntity allCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @PostMapping("/car/add")
    public ResponseEntity addCar(@RequestBody Car car) {
        return ResponseEntity.ok(carService.addCar(car));
    }

}
