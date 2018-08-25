package com.vengard.rentis.Car;

import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity(name = "CAR")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String brand;
    @NotEmpty
    private String model;
    @NotEmpty
    private String generation;

    private Integer yearbook;

    @Nullable
    private Date dateReturn;

    @NotEmpty
    private Boolean isAvailable;

    public Car() {
    }

    public Car(@NotEmpty String brand, @NotEmpty String model, @NotEmpty String generation, Integer yearbook, @NotEmpty Boolean isAvailable) {
        this.brand = brand;
        this.model = model;
        this.generation = generation;
        this.yearbook = yearbook;
        this.isAvailable = isAvailable;
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

    public Boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }



}
