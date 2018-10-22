package com.vengard.rentis.service.rentcalculator;

import com.vengard.rentis.model.Car;
import com.vengard.rentis.model.RentCarPostObject;

public class RentCarCalculatorNormal extends RentCarCalculatorAbs {

    @Override
    public float calculateRentCost(RentCarPostObject rentCarPostObject, Car car) {
        float sum = 0;
        long diff = getTimeDifferenceInDays(rentCarPostObject.getDateRent().getTime(), rentCarPostObject.getPlannedDateReturn().getTime());

        sum += (int) diff * car.getCostPerDay();

        return sum;
    }
}
