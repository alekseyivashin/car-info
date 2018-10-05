package com.dell.alekseyivashin.carinfo;

import com.dell.alekseyivashin.carinfo.model.CarCenter;
import com.dell.alekseyivashin.carinfo.repository.CarCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class StartupRunner implements ApplicationRunner {


    private final CarCenterRepository carCenterRepository;

    @Autowired
    public StartupRunner(CarCenterRepository carCenterRepository) {
        this.carCenterRepository = carCenterRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        BigInteger mainCenterId = BigInteger.valueOf(123456789);
        if (!carCenterRepository.findById(mainCenterId).isPresent()) {
            CarCenter mainCenter = new CarCenter();
            mainCenter.setId(mainCenterId);
            mainCenter.setCountry("Russia");
            mainCenter.setCity("St. Petersburg");
            carCenterRepository.save(mainCenter);
        }
    }


}
