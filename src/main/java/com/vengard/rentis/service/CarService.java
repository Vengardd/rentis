package com.vengard.rentis.service;

import com.vengard.rentis.exception.CarNotFoundException;
import com.vengard.rentis.model.Car;
import com.vengard.rentis.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car addCar(Car car) {
        return carRepository.save(car);
    }
    public Car findById(Long id) throws CarNotFoundException{
        return carRepository.findById(id).orElseThrow(CarNotFoundException::new);
    }

}
