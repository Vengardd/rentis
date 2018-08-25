package com.vengard.rentis.Car;

import com.vengard.rentis.RentHistory.RentHistory;
import com.vengard.rentis.RentHistory.RentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private RentHistoryService rentHistoryService;

    @GetMapping("/car/all")
    public List<Car> allCars() {
        return carService.getAllCars();
    }

    @PostMapping("/car/add")
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    //ToDo refactor
    @PostMapping("/rentcar")
    public RentHistory rentCar2(@RequestBody Map<String, Object> objects, @ModelAttribute RentHistory rentHistory) {
        int i = (Integer)objects.get("id");
        Long l = new Long(i);
        Date dateRent = null;
        Date plannedDateReturn = null;
        try {
            dateRent = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX").parse((String) objects.get("dateRent"));
            plannedDateReturn = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX").parse((String) objects.get("plannedDateReturn"));
        }
        catch(Exception e) {
            return null;
        }
        return rentHistoryService.addRentHistory(new RentHistory(carService.findById(l), new Date(), dateRent, plannedDateReturn));
    }
}
