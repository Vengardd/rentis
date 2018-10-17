package com.vengard.rentis.controller;

import com.vengard.rentis.exception.CarNotFoundException;
import com.vengard.rentis.service.RentService;
import com.vengard.rentis.model.RentHistory;
import com.vengard.rentis.model.RentCarPostObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class RentController {

    @Autowired
    RentService rentService;

    @GetMapping("/rent/{id}")
    public List<List<Timestamp>> notAvailableTerms(@PathVariable("id") Long id) throws CarNotFoundException{
        return rentService.getNotAvailableTerms(id);
    }

    @PostMapping("/rent")
    public RentHistory rentCar(@RequestBody RentCarPostObject rentCarPostObject) throws CarNotFoundException{
        return rentService.rentCar(rentCarPostObject);
    }
}
