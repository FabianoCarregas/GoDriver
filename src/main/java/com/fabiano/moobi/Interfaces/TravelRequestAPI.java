package com.fabiano.moobi.Interfaces;

import com.fabiano.moobi.Domain.TravelRequest;
import com.fabiano.moobi.Interfaces.input.TravelRequestInput;
import com.fabiano.moobi.Interfaces.mapping.TravelRequestMapper;
import com.fabiano.moobi.Interfaces.output.TravelRequestOutput;
import com.fabiano.moobi.Repositories.TravelRequestRepository;
import com.fabiano.moobi.Services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
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

    @Autowired
    private TravelRequestMapper travelRequestMapper;

    @PostMapping
    public EntityModel<TravelRequestOutput> makeTravelRequest(@RequestBody TravelRequestInput travelRequestInput) {
       TravelRequest travelRequest = travelService.saveTravelRequest(travelRequestMapper.map(travelRequestInput));
       TravelRequestOutput output = travelRequestMapper.map(travelRequest);
       return travelRequestMapper.buildOutputModel(travelRequest, output);
    }
}
