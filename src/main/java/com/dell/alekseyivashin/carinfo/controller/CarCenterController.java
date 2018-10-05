package com.dell.alekseyivashin.carinfo.controller;

import com.dell.alekseyivashin.carinfo.model.Car;
import com.dell.alekseyivashin.carinfo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/centers")
public class CarCenterController extends AbstractController {

    private final CarService carService;

    @Autowired
    public CarCenterController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{centerId}/cars")
    public ResponseEntity getAll(@PathVariable BigInteger centerId) {
        List<Car> cars = carService.getAll(centerId);
        return nonNullBodyOrError(cars);
    }

    @PostMapping("/{centerId}/cars")
    public ResponseEntity save(@RequestBody Car car, @PathVariable BigInteger centerId) {
        Car savedCar = carService.save(car, centerId);
        return nonNullBodyOrError(savedCar);
    }
}
