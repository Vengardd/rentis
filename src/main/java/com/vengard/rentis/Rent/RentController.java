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
        rentService.rentCar(rentCarPostObject);
        return null;
    }

//    //ToDo refactor
//    @PostMapping("/rent")
//    public RentHistory rentCar2(@RequestBody Map<String, Object> objects, @ModelAttribute RentHistory rentHistory) {
//        int i = (Integer)objects.get("id");
//        Long l = new Long(i);
//        Date dateRent = null;
//        Date plannedDateReturn = null;
//        try {
//            dateRent = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX").parse((String) objects.get("dateRent"));
//            plannedDateReturn = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX").parse((String) objects.get("plannedDateReturn"));
//        }
//        catch(Exception e) {
//            return null;
//        }
////        return rentHistoryService.addRentHistory(new RentHistory(carService.findById(l), new Date(), dateRent, plannedDateReturn));
//        return null;
//    }

}
