package com.ilya.springBootCar.controller;

import com.ilya.springBootCar.model.Car;
import com.ilya.springBootCar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CarController {
    private final CarService carService;
    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String findAll(Model model){
        List<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "carList";
    }

    @GetMapping("/cars/create")
    public String createCarForm(Car car){
        return"carCreate";
    }

    @PostMapping("/cars/create")
    public String createCar(@Valid Car car, BindingResult bindingResult){
        if(bindingResult.hasErrors()){

        }
        carService.saveCar(car);
        return "redirect:/cars";
    }

    @GetMapping("/cars/delete/{id}")
    public String deleteCar(@PathVariable("id") Long id){
        carService.deleteById(id);
        return "redirect:/cars";
    }
}
