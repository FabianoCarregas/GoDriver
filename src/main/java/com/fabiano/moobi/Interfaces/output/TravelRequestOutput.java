package com.fabiano.moobi.Interfaces.output;

import com.fabiano.moobi.Domain.Passenger;
import com.fabiano.moobi.Domain.enums.TravelRequestStatus;
import lombok.Data;

import java.util.Date;

@Data
public class TravelRequestOutput {

    private Long id;
    private String origin;
    private String destination;
    private TravelRequestStatus travelRequestStatus;
    private Date creationDate;
}
