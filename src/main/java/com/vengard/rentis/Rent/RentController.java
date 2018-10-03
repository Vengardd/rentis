package com.vengard.rentis.Rent;

import com.vengard.rentis.RentHistory.RentHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class RentController {

    @Autowired
    RentService rentService;

    @GetMapping("/rent/{id}")
    public List<List<Timestamp>> notAvailableTerms(@PathVariable("id") Long id) {
        return rentService.getNotAvailableTerms(id);
    }

    @PostMapping("/rent")
    public RentHistory rentCar(@RequestBody RentCarPostObject rentCarPostObject) {
        return rentService.rentCar(rentCarPostObject);
    }
}
