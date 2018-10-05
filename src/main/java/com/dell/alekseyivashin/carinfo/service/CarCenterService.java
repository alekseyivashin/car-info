package com.dell.alekseyivashin.carinfo.service;

import com.dell.alekseyivashin.carinfo.model.Car;
import com.dell.alekseyivashin.carinfo.model.CarCenter;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public interface CarCenterService {
    CarCenter get(BigInteger centerId);
    CarCenter get(Car car);
    CarCenter save(CarCenter center);
}
