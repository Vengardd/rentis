package com.vengard.rentis.service.rentcalculator;

import com.vengard.rentis.model.Car;
import com.vengard.rentis.model.RentCarPostObject;

public abstract class RentCarCalculatorAbs {

    abstract public float calculateRentCost(RentCarPostObject rentCarPostObject, Car car);

    protected long getTimeDifferenceInDays(long dateFirst, long dateSecond) {
        return Math.abs((dateFirst + dateSecond) / (1000 * 60 * 60 * 24));
    }
}
