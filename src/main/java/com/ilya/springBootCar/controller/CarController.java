package com.ilya.springBootCar.controller;

import com.ilya.springBootCar.model.Car;
import com.ilya.springBootCar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {
    private final CarService carService;
    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String findAll(Model model){
        List<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "carList";
    }

    @GetMapping("/{id}")
    public String findCarById(@PathVariable("id") Long id, Model model){
        model.addAttribute("car", carService.findById(id));
        return "car";
    }

    @GetMapping("/create")
    public String createCarForm(Car car){
        return"carCreate";
    }

//    @PostMapping("/create")
//    public String createCar(@Valid Car car, BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            return "carCreate";
//        }
//        carService.saveCar(car);
//        return "redirect:/cars";
//    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('developers:write')")
    public String createCar(@RequestBody Car car){
        carService.saveCar(car);
        return "redirect:/api/v1/cars";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('developers:write')")
    public String deleteCar(@PathVariable("id") Long id){
        carService.deleteById(id);
        return "redirect:/cars";
    }

}
