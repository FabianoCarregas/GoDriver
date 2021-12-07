package com.fabiano.moobi.Domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Driver {

    @Id
    private Long id;
    private String name;
    private Date birthDate;
}
