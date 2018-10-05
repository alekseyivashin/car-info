package com.dell.alekseyivashin.carinfo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "centers")
public class CarCenter {

    @Id
    @Min(0)
    private BigInteger id;

    @Indexed
    private String country;

    @Indexed
    private String city;

    @DBRef
    private List<Car> storedCars = new ArrayList<>();
}
