package com.vengard.rentis.Car;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long>{

    List findAll();

}
