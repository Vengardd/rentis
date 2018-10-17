package com.vengard.rentis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vengard.rentis.model.Car;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "RENT_HISTORY")
public class RentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Car")
    private Car car;

    @OneToOne(fetch = FetchType.EAGER)
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

    public User getLender() {
        return lender;
    }

    public void setLender(User lender) {
        this.lender = lender;
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

    public static final class RentHistoryBuilder {
        private Long id;
        private Car car;
        private User lender;
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

        public RentHistoryBuilder withLender(User lender) {
            this.lender = lender;
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
            rentHistory.lender = this.lender;
            return rentHistory;
        }
    }
}
