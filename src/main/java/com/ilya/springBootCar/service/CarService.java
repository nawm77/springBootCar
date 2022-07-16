package com.ilya.springBootCar.service;

import com.ilya.springBootCar.model.Car;
import com.ilya.springBootCar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car findById(Long id){
        return carRepository.getOne(id);
    }

    public List<Car> findAll(){
        return carRepository.findAll();
    }

    public Car saveCar(Car car){
        return carRepository.save(car);
    }

    public void deleteById(Long id){
        carRepository.deleteById(id);
    }
}
