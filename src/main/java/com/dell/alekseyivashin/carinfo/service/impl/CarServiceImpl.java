package com.dell.alekseyivashin.carinfo.service.impl;

import com.dell.alekseyivashin.carinfo.model.Car;
import com.dell.alekseyivashin.carinfo.model.CarCenter;
import com.dell.alekseyivashin.carinfo.repository.CarRepository;
import com.dell.alekseyivashin.carinfo.service.CarCenterService;
import com.dell.alekseyivashin.carinfo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Component
public class CarServiceImpl implements CarService {


    private final CarRepository carRepository;
    private final CarCenterService carCenterService;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, CarCenterService carCenterService) {
        this.carRepository = carRepository;
        this.carCenterService = carCenterService;
    }

    @Override
    public Car get(BigInteger serialNumber) {
        return carRepository.findById(serialNumber).orElse(null);
    }

    @Override
    public Car update(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car delete(BigInteger serialNumber) {
        Optional<Car> carOptional = carRepository.findById(serialNumber);
        if (carOptional.isPresent()) {
            Car car = carOptional.get();
            CarCenter center = carCenterService.get(car);
            center.getStoredCars().remove(car);
            carCenterService.save(center);
            carRepository.delete(car);
            return car;
        }
        return null;
    }

    @Override
    public List<Car> getAll(BigInteger centerId) {
        CarCenter center = carCenterService.get(centerId);
        if (center != null) {
            return center.getStoredCars();
        }
        return null;
    }

    @Override
    public Car save(Car car, BigInteger centerId) {
        CarCenter center = carCenterService.get(centerId);
        if (center != null) {
            Car savedCar = carRepository.save(car);
            center.getStoredCars().add(savedCar);
            carCenterService.save(center);
            return savedCar;
        }
        return null;
    }
}
