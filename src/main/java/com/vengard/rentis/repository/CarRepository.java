package com.vengard.rentis.repository;

import com.vengard.rentis.model.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findAll();
    Car save(Car car);
    void deleteById(Long id);

}