package com.vengard.rentis.service;

import com.vengard.rentis.exception.CarNotFoundException;
import com.vengard.rentis.model.Car;
import com.vengard.rentis.model.RentCarPostObject;
import com.vengard.rentis.model.RentHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class RentService {

    @Autowired
    private CarService carService;

    @Autowired
    private RentHistoryService rentHistoryService;

    public RentHistory rentCar(RentCarPostObject rentCarPostObject) throws CarNotFoundException {
        return rentHistoryService.addRentHistory(rentCarPostObject);
    }

    public List<List<Timestamp>> getNotAvailableTerms(Long id) throws CarNotFoundException {
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

    public Float countRentCost(RentCarPostObject rentCarPostObject) {
        return 5f;
    }
}
