package com.ilya.springBootCar.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="make")
    @Size(min = 2, max = 20, message = "Размер марки должен быть не менее 2 - х и не более 20 символов")
    @NotEmpty(message = "Марка не божет быть пустой")
    private String make;
    @Column(name="model")
    @NotEmpty(message = "Модель должна быть указана")
    @Size(max = 20, message = "Размер модели не может превышать 20 символов")
    private String model;
    @Min(value = 1, message = "Авто должно иметь хотя бы 1 л.с.")
    @Column(name="horsepower")
    private int horsePower;
    @Min(value=1800, message = "Год производства должен быть не меньше 1800")
    @Max(value = 2022, message = "Год производства должен быть не больше 2022")
    @Column(name = "yearofproduction")
    private int yearOfProduction;
    @Column(name="price")
    @Min(value = 1, message = "Цена должна быть больше 0")
    private int price;
    @Column(name="owners")
    @Min(value = 0, message = "Количество владельцев должно быть не меньше 0")
    private int owners;
    @Column(name="acceleration")
    @Min(value = 1, message = "Ускорение не может быть меньше 1 секунды")
    private float acceleration;
}
