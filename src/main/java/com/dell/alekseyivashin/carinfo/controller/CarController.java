package com.dell.alekseyivashin.carinfo.controller;

import com.dell.alekseyivashin.carinfo.model.Car;
import com.dell.alekseyivashin.carinfo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping("/cars")
public class CarController extends AbstractController {


    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{serialNumber}")
    public ResponseEntity get(@PathVariable BigInteger serialNumber) {
        Car car = carService.get(serialNumber);
        return nonNullBodyOrError(car);
    }

    @PutMapping()
    public ResponseEntity update(@RequestBody Car car) {
        Car updatedCar = carService.update(car);
        return nonNullBodyOrError(updatedCar);
    }

    @DeleteMapping("/{serialNumber}")
    public ResponseEntity delete(@PathVariable BigInteger serialNumber) {
        Car deletedCar = carService.delete(serialNumber);
        return ResponseEntity.ok(deletedCar);
    }
}
