package com.ilya.springBootCar.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "motos")
public class Moto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 1, max = 30)
    @Column(name="make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name="horsepower")
    private int horsePower;
    @Column(name = "yearofproduction")
    private int yearOfProduction;
    @Column(name="price")
    private int price;
    @Column(name="owners")
    private int owners;

    @Column(name="acceleration")
    private float acceleration;
}
