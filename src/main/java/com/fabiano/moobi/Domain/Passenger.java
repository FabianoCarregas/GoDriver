package com.fabiano.moobi.Domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Data
@Entity
public class Passenger {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany
    TravelRequest travelRequest;

}
