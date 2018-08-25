package com.vengard.rentis.Car;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long>{

    List findAll();
    Car save(Car car);
    void deleteById(Long id);

}