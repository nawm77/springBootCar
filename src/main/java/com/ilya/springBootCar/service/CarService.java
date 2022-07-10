package com.ilya.springBootCar.service;

import com.ilya.springBootCar.model.Car;
import com.ilya.springBootCar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final UserRepository userRepository;

    @Autowired
    public CarService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Car findById(Long id){
        return userRepository.getOne(id);
    }

    public List<Car> findAll(){
        return userRepository.findAll();
    }

    public Car saveCar(Car car){
        return userRepository.save(car);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}
