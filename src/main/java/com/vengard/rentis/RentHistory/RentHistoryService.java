package com.vengard.rentis.RentHistory;

import com.vengard.rentis.Car.Car;
import com.vengard.rentis.Car.CarService;
import com.vengard.rentis.Rent.RentCarPostObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class RentHistoryService {

    @Autowired
    private RentHistoryRepository rentHistoryRepository;

    @Autowired
    private CarService carService;

    public RentHistory addRentHistory(RentHistory rentHistory) {
        return rentHistoryRepository.save(rentHistory);
    }

    public RentHistory addRentHistory(RentCarPostObject rentCarPostObject) {
        return rentHistoryRepository.save(RentHistoryBuilder.aRentHistory()
                .withCar(carService.findById(rentCarPostObject.getCarId()))
                .withDateOrder(new Timestamp(System.currentTimeMillis()))
                .withDateRent(rentCarPostObject.getDateRent())
                .withPlannedDateReturn(rentCarPostObject.getPlannedDateReturn())
                .build());
    }

    public List<RentHistory> rentHistoriesForCar(Car car, Timestamp dateRent) {
        return rentHistoryRepository.findAllByCarAndDateRentIsAfter(car, dateRent);
    }

}
