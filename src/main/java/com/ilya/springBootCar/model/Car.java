package com.ilya.springBootCar.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="make")
    private String make;
    @Column(name="model")
    private String model;
    @Min(value = 1)
    @Column(name="horsepower")
    private int horsePower;
    @Min(value=1800)
    @Max(value = 2022)
    @Column(name = "yearofproduction")
    private int yearOfProduction;
    @Column(name="price")
    private int price;
    @Column(name="owners")
    private int owners;
    @Column(name="acceleration")
    private float acceleration;
}
