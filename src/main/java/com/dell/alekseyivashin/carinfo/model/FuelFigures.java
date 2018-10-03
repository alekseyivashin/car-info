package com.dell.alekseyivashin.carinfo.model;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class FuelFigures {

    @Min(0)
    private Short speed;

    @Min(0)
    private Float mpg;

    private String usageDescription;


}
