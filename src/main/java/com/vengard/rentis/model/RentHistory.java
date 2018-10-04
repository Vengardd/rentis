package com.vengard.rentis.model;

import com.vengard.rentis.model.Car;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity(name = "RENT_HISTORY")
public class RentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Car")
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User")
    private User lender;

    private Timestamp dateOrder;
    private Timestamp dateRent;
    private Timestamp plannedDateReturn;
    private Timestamp dateReturn;

    private Long rentCost;

    public RentHistory() {
    }

    public RentHistory(@NotNull Car car, Timestamp dateOrder, Timestamp dateRent, Timestamp plannedDateReturn) {
        this.car = car;
        this.dateOrder = dateOrder;
        this.dateRent = dateRent;
        this.plannedDateReturn = plannedDateReturn;
    }

    public RentHistory(@NotNull Car car, Timestamp dateOrder, Timestamp dateRent, Timestamp plannedDateReturn, Timestamp dateReturn, Long rentCost) {
        this.car = car;
        this.dateOrder = dateOrder;
        this.dateRent = dateRent;
        this.plannedDateReturn = plannedDateReturn;
        this.dateReturn = dateReturn;
        this.rentCost = rentCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Timestamp getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Timestamp dateOrder) {
        this.dateOrder = dateOrder;
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

    public Timestamp getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Timestamp dateReturn) {
        this.dateReturn = dateReturn;
    }

    @Override
    public String toString() {
        return "RentHistory{" +
                "id=" + id +
                ", car=" + car +
                ", dateOrder=" + dateOrder +
                ", dateRent=" + dateRent +
                ", plannedDateReturn=" + plannedDateReturn +
                ", dateReturn=" + dateReturn +
                ", rentCost=" + rentCost +
                '}';
    }
}
