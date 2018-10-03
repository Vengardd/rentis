package com.vengard.rentis.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/car/all")
    public List<Car> allCars() {
        return carService.getAllCars();
    }

    @PostMapping("/car/add")
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

}
