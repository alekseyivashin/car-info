package com.dell.alekseyivashin.carinfo.service;

import com.dell.alekseyivashin.carinfo.model.Car;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public interface CarService {
    Car get(BigInteger serialNumber);
    Car update(Car car);
    Car delete(BigInteger serialNumber);

    List<Car> getAll(BigInteger centerId);
    Car save(Car car, BigInteger centerId);
}
