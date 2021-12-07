package com.fabiano.moobi.Interfaces;

import com.fabiano.moobi.Domain.Driver;
import com.fabiano.moobi.Repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class DriverAPI {

    @Autowired
    DriverRepository driverRepository;

    @GetMapping("/drivers")
    public List<Driver> listDrivers() {
        return driverRepository.findAll();
    }

    @GetMapping("/drivers/{id}")
    public Driver driverById(@PathVariable("id") Long id){
        return driverRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/drivers")
    public Driver createDriver(@RequestBody Driver driver) {
        return driverRepository.save(driver);
    }

    @PutMapping("drivers/{id}")
    public Driver fullUpdateDriver(@PathVariable("id") Long id, @RequestBody Driver driver) {
        Driver foundDriver = driverById(id);
        foundDriver.setName(driver.getName());
        foundDriver.setBirthDate(driver.getBirthDate());
        return driverRepository.save(foundDriver);
    }
}
