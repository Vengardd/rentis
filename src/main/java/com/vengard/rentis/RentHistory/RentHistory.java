package com.vengard.rentis.RentHistory;

import com.vengard.rentis.Car.Car;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "RENT_HISTORY")
public class RentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Car")
    private Car car;

    private Date dateOrder;
    private Date dateRent;
    private Date plannedDateReturn;
    private Date dateReturn;

    private Long rentCost;

    public RentHistory() {
    }

    public RentHistory(@NotNull Car car, Date dateOrder, Date dateRent, Date plannedDateReturn) {
        this.car = car;
        this.dateOrder = dateOrder;
        this.dateRent = dateRent;
        this.plannedDateReturn = plannedDateReturn;
    }

    public RentHistory(@NotNull Car car, Date dateOrder, Date dateRent, Date plannedDateReturn, Date dateReturn, Long rentCost) {
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

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Date getDateRent() {
        return dateRent;
    }

    public void setDateRent(Date dateRent) {
        this.dateRent = dateRent;
    }

    public Date getPlannedDateReturn() {
        return plannedDateReturn;
    }

    public void setPlannedDateReturn(Date plannedDateReturn) {
        this.plannedDateReturn = plannedDateReturn;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
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
