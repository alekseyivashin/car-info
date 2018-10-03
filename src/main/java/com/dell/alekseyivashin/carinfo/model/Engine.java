package com.dell.alekseyivashin.carinfo.model;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class Engine {

    @Min(0)
    private Short capacity;

    @Min(0)
    private Byte numCylinders;

    @Min(0)
    private Short maxRpm;

    private Character manufacturerCode;

}
