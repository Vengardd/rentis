//package com.vengard.rentis.Service;
//
//import com.vengard.rentis.Car.Car;
//import com.vengard.rentis.Car.CarService;
//import com.vengard.rentis.RentHistory.RentHistory;
//import com.vengard.rentis.RentHistory.RentHistoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//
//@Service
//public class RentCarService {
//
//    @Autowired
//    private CarService carService;
//
//    @Autowired
//    private RentHistoryService rentHistoryService;
//
//    public Car rentCar(Long id, Date dateRent, Date dateReturn) {
//        Car car = carService.findById(id);
//        if (car == null)
//            return null;
//        else {
//            car.setAvailable(false);
//            rentHistoryService.addRentHistory(new RentHistory(car, new Date(), dateRent, dateReturn));
//        }
//        return car;
//    }
//
//}
