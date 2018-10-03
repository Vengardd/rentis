package com.vengard.rentis.model;

import java.sql.Timestamp;

public class RentCarPostObject {

    private Long carId;
    private Timestamp dateRent;
    private Timestamp plannedDateReturn;

    public RentCarPostObject() {
    }

    public RentCarPostObject(String carId, Timestamp dateRent, Timestamp plannedDateReturn) {
        this.carId = Long.valueOf(carId);
        this.dateRent = dateRent;
        this.plannedDateReturn = plannedDateReturn;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Timestamp getDateRent() {
        return dateRent;
    }

    public void setDateRent(Timestamp dateRent) {
        this.dateRent = dateRent;
    }

    public Timestamp getPlannedDateReturn() {
        return plannedDateReturn;
    }

    public void setPlannedDateReturn(Timestamp plannedDateReturn) {
        this.plannedDateReturn = plannedDateReturn;
    }
}
