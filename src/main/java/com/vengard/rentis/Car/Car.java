package com.vengard.rentis.Car;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
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

    private Integer yearProduction;

    @NotEmpty
    private Boolean isAvaible;

    public Car() {
    }

    public Car(@NotEmpty String brand, @NotEmpty String model, @NotEmpty String generation, Integer yearProduction, @NotEmpty Boolean isAvaible) {
        this.brand = brand;
        this.model = model;
        this.generation = generation;
        this.yearProduction = yearProduction;
        this.isAvaible = isAvaible;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getGeneration() {
        return generation;
    }

    public Integer getYearProduction() {
        return yearProduction;
    }

    public Boolean getAvaible() {
        return isAvaible;
    }
}
