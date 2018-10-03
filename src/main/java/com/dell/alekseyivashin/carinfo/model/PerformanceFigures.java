package com.dell.alekseyivashin.carinfo.model;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class PerformanceFigures {

    @Min(0)
    private Short octaneRating;

    private Acceleration acceleration;

}
