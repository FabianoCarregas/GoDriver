package com.fabiano.moobi.Interfaces.input;

import com.fabiano.moobi.Domain.Passenger;
import lombok.Data;

@Data
public class TravelRequestInput {

    private Long passengerId;
    private String origin;
    private String destination;

}
