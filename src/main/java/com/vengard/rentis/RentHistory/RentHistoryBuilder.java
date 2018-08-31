package com.vengard.rentis.RentHistory;

import com.vengard.rentis.Car.Car;

import java.sql.Timestamp;

public final class RentHistoryBuilder {
    private Long id;
    private Car car;
    private Timestamp dateOrder;
    private Timestamp dateRent;
    private Timestamp plannedDateReturn;
    private Timestamp dateReturn;
    private Long rentCost;

    private RentHistoryBuilder() {
    }

    public static RentHistoryBuilder aRentHistory() {
        return new RentHistoryBuilder();
    }

    public RentHistoryBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public RentHistoryBuilder withCar(Car car) {
        this.car = car;
        return this;
    }

    public RentHistoryBuilder withDateOrder(Timestamp dateOrder) {
        this.dateOrder = dateOrder;
        return this;
    }

    public RentHistoryBuilder withDateRent(Timestamp dateRent) {
        this.dateRent = dateRent;
        return this;
    }

    public RentHistoryBuilder withPlannedDateReturn(Timestamp plannedDateReturn) {
        this.plannedDateReturn = plannedDateReturn;
        return this;
    }

    public RentHistoryBuilder withDateReturn(Timestamp dateReturn) {
        this.dateReturn = dateReturn;
        return this;
    }

    public RentHistoryBuilder withRentCost(Long rentCost) {
        this.rentCost = rentCost;
        return this;
    }

    public RentHistory build() {
        RentHistory rentHistory = new RentHistory(car, dateOrder, dateRent, plannedDateReturn, dateReturn, rentCost);
        rentHistory.setId(id);
        return rentHistory;
    }
}
