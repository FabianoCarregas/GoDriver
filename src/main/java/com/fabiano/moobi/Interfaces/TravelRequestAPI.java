package com.fabiano.moobi.Interfaces;

import com.fabiano.moobi.Domain.TravelRequest;
import com.fabiano.moobi.Interfaces.input.TravelRequestInput;
import com.fabiano.moobi.Repositories.TravelRequestRepository;
import com.fabiano.moobi.Services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequestMapping(path = "/travelrequests", produces = MediaType.APPLICATION_JSON_VALUE)
public class TravelRequestAPI {

    @Autowired
    private TravelService travelService;

    @PostMapping
    public void makeTravelRequest(@RequestBody TravelRequestInput travelRequest) {
        travelService.saveTravelRequest(travelRequest);
    }
}