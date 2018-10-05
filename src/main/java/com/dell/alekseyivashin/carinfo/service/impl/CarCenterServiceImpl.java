package com.dell.alekseyivashin.carinfo.service.impl;

import com.dell.alekseyivashin.carinfo.model.Car;
import com.dell.alekseyivashin.carinfo.model.CarCenter;
import com.dell.alekseyivashin.carinfo.repository.CarCenterRepository;
import com.dell.alekseyivashin.carinfo.service.CarCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class CarCenterServiceImpl implements CarCenterService {

    private final CarCenterRepository carCenterRepository;

    @Autowired
    public CarCenterServiceImpl(CarCenterRepository carCenterRepository) {
        this.carCenterRepository = carCenterRepository;
    }

    @Override
    public CarCenter get(BigInteger centerId) {
        return carCenterRepository.findById(centerId).orElse(null);
    }

    @Override
    public CarCenter get(Car car) {
        return carCenterRepository.findByStoredCarsContains(car);
    }

    @Override
    public CarCenter save(CarCenter center) {
        return carCenterRepository.save(center);
    }
}
