package com.fabiano.moobi.Domain;

import lombok.Data;

import javax.persistence.*;

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
}
