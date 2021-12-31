package com.fabiano.moobi.Domain;

import com.fabiano.moobi.Domain.enums.TravelRequestStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class TravelRequest {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    public Passenger passenger;

    private String origin;
    private String destination;

    @Enumerated(EnumType.STRING)
    private TravelRequestStatus travelRequestStatus;
    private Date creationDate;
}
