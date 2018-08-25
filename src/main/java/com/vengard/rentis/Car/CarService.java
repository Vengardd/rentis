package com.vengard.rentis.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Car findById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public Car findAvaibleById(Long id) {
        return carRepository.findById(id)
                .filter(Car::isAvailable)
                .orElseThrow(() -> new RuntimeException());
    }

    public Car setAvailability(Car oldCar, boolean availability) {
        Car newCar = carRepository.findById(oldCar.getId()).orElse(null);
        if (newCar == null)
            throw new RuntimeException();
        newCar.setAvailable(availability);
        swapCar(oldCar, newCar);
        return newCar;
    }

    private void swapCar(Car oldCar, Car newCar) {
        carRepository.deleteById(oldCar.getId());
        carRepository.save(newCar);
    }
}
