package com.vengard.rentis.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/car")
    public ModelAndView allCars() {
        ModelAndView model = new ModelAndView("allCars");
        model.addObject("cars", carService.getAllCars());
        return model;
    }


}
