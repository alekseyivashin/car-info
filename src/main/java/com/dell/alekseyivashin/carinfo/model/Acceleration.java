package com.dell.alekseyivashin.carinfo.model;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class Acceleration {

    @Min(0)
    private Short mph;

    @Min(0)
    private Float seconds;

}
