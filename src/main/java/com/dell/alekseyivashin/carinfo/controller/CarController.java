package com.dell.alekseyivashin.carinfo.controller;

import com.dell.alekseyivashin.carinfo.model.Car;
import com.dell.alekseyivashin.carinfo.model.Engine;
import com.dell.alekseyivashin.carinfo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public void add() {
        Car car = new Car();
        car.setOwnerName("test");
        car.setModelYear(BigInteger.valueOf(3759));
        Engine engine = new Engine();
        engine.setMaxRpm((short) 20);
        engine.setNumCylinders((byte) 5);
        car.setEngine(engine);

        carRepository.insert(car);

        List<Car> all = carRepository.findAll();

        System.out.println(all);
    }
}
