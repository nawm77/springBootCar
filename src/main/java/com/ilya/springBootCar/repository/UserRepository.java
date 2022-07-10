package com.ilya.springBootCar.repository;

import com.ilya.springBootCar.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Car, Long> {
}
