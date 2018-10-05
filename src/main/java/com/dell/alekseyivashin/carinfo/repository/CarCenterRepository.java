package com.dell.alekseyivashin.carinfo.repository;

import com.dell.alekseyivashin.carinfo.model.Car;
import com.dell.alekseyivashin.carinfo.model.CarCenter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.List;

public interface CarCenterRepository extends MongoRepository<CarCenter, BigInteger> {
    List<CarCenter> findAllByCountry(String country);
    List<CarCenter> findAllByCity(String city);
    CarCenter findByStoredCarsContains(Car car);
}
