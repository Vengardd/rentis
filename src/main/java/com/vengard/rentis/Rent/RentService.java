package com.vengard.rentis.Rent;

import com.vengard.rentis.Car.Car;
import com.vengard.rentis.Car.CarService;
import com.vengard.rentis.RentHistory.RentHistory;
import com.vengard.rentis.RentHistory.RentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class RentService {

    @Autowired
    private CarService carService;

    @Autowired
    private RentHistoryService rentHistoryService;

    public RentHistory rentCar(RentCarPostObject rentCarPostObject) {
        rentHistoryService.addRentHistory(rentCarPostObject);
        return null;
    }

    public List<List<Timestamp>> getNotAvailableTerms(Long id) {
        Car car = carService.findById(id);
        List<List<Timestamp>> list = new LinkedList<>();
        rentHistoryService.rentHistoriesForCar(car, new Timestamp(System.currentTimeMillis()))
                .forEach(r -> {
                    List<Timestamp> timestamps = new LinkedList<>();
                    timestamps.add(r.getDateRent());
                    timestamps.add(r.getPlannedDateReturn());
                    list.add(timestamps);
                });
        return list;
    }
}
