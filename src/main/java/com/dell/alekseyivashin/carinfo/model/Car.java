package com.dell.alekseyivashin.carinfo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import java.math.BigInteger;

@Data
@Document(collection = "cars")
public class Car {

    private String ownerName;

    @Id
    @Min(0)
    private BigInteger serialNumber;

    @Min(0)
    private BigInteger modelYear;

    private String code;

    private String vehicleCode;

    private Engine engine;

    private FuelFigures fuelFigures;

    private PerformanceFigures performanceFigures;

    private String manufacturer;

    private String model;

    private String activationCode;

}
