package com.fabiano.moobi.Services;

import com.fabiano.moobi.Domain.TravelRequest;
import com.fabiano.moobi.Domain.enums.TravelRequestStatus;
import com.fabiano.moobi.Repositories.TravelRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TravelService {

    @Autowired
    private TravelRequestRepository travelRequestRepository;

    public TravelRequest saveTravelRequest(TravelRequest travelRequest) {
        travelRequest.setTravelRequestStatus(TravelRequestStatus.CREATED);
        travelRequest.setCreationDate(new Date());
        return travelRequestRepository.save(travelRequest);
    }

}
