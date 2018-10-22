package com.vengard.rentis.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Component
@Entity(name = "CAR")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private String generation;
    private Integer yearbook;

    private Long costPerDay;

    public Car() {
    }

    public Car(@NotEmpty String brand, @NotEmpty String model, @NotEmpty String generation, Integer yearbook) {
        this.brand = brand;
        this.model = model;
        this.generation = generation;
        this.yearbook = yearbook;
    }

    public Long getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(Long costPerDay) {
        this.costPerDay = costPerDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public Integer getYearbook() {
        return yearbook;
    }

    public void setYearbook(Integer yearbook) {
        this.yearbook = yearbook;
    }

}
