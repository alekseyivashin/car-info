package com.dell.alekseyivashin.carinfo.repository;

import com.dell.alekseyivashin.carinfo.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CarRepository extends MongoRepository<Car, BigInteger> {
}
