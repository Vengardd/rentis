package com.vengard.rentis.service;

import com.vengard.rentis.exception.CarNotFoundException;
import com.vengard.rentis.model.Car;
import com.vengard.rentis.model.RentCarPostObject;
import com.vengard.rentis.model.RentHistory;
import com.vengard.rentis.model.User;
import com.vengard.rentis.repository.RentHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class RentHistoryService {

    @Autowired
    private RentHistoryRepository rentHistoryRepository;

    @Autowired
    private CarService carService;

    public List<RentHistory> findRentHistoryByUser(User lender) {
        return rentHistoryRepository.findAllByLender(lender);
    }

    public RentHistory addRentHistory(RentHistory rentHistory) throws CarNotFoundException {
        Car car = carService.findById(rentHistory.getCar().getId());
        return rentHistoryRepository.save(rentHistory);
    }

    public RentHistory addRentHistory(RentCarPostObject rentCarPostObject) throws CarNotFoundException {
        Car car = carService.findById(rentCarPostObject.getCarId());
        return rentHistoryRepository.save(RentHistory.RentHistoryBuilder.aRentHistory()
                .withCar(car)
                .withDateOrder(new Timestamp(System.currentTimeMillis()))
                .withDateRent(rentCarPostObject.getDateRent())
                .withPlannedDateReturn(rentCarPostObject.getPlannedDateReturn())
                .build());
    }

    public List<RentHistory> rentHistoriesForCar(Car car, Timestamp dateRent) {
        return rentHistoryRepository.findAllByCarAndDateRentIsAfter(car, dateRent);
    }

}
