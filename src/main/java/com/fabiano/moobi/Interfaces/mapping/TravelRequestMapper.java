package com.fabiano.moobi.Interfaces.mapping;

import com.fabiano.moobi.Domain.Passenger;
import com.fabiano.moobi.Domain.TravelRequest;
import com.fabiano.moobi.Interfaces.PassengerAPI;
import com.fabiano.moobi.Interfaces.input.TravelRequestInput;
import com.fabiano.moobi.Interfaces.output.TravelRequestOutput;
import com.fabiano.moobi.Repositories.PassengerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class TravelRequestMapper {

    @Autowired
    private PassengerRepository passengerRepository;

    public TravelRequest map(TravelRequestInput input) {
        Passenger passenger = passengerRepository.findById(input.getPassengerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        TravelRequest travelRequest = new TravelRequest();
        travelRequest.setOrigin(input.getOrigin());
        travelRequest.setDestination(input.getDestination());
        travelRequest.setPassenger(passenger);
        return travelRequest;
    }

    public TravelRequestOutput map(TravelRequest travelRequest) {
       TravelRequestOutput travelRequestOutput = new TravelRequestOutput();
       travelRequestOutput.setCreationDate(travelRequest.getCreationDate());
       travelRequestOutput.setDestination(travelRequest.getDestination());
       travelRequestOutput.setId(travelRequest.getId());
       travelRequestOutput.setOrigin(travelRequest.getOrigin());
       travelRequestOutput.setTravelRequestStatus(travelRequest.getTravelRequestStatus());
        return travelRequestOutput;
    }

    public EntityModel<TravelRequestOutput> buildOutputModel(TravelRequest travelRequest, TravelRequestOutput output){
        EntityModel<TravelRequestOutput> model = new EntityModel<>(output);
        Link passengerLink = WebMvcLinkBuilder
                .linkTo(PassengerAPI.class)
                .slash(travelRequest.getPassenger().getId())
                .withRel("passenger")
                .withTitle(travelRequest.getPassenger().getName());
        model.add(passengerLink);
        return model;
    }
}
