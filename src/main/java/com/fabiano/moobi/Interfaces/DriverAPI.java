package com.fabiano.moobi.Interfaces;

import com.fabiano.moobi.Domain.Driver;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Service
@RestController
public class DriverAPI {

    @GetMapping
    public List<Driver> listDrivers() {
        return new ArrayList<>();
    }

    
}
