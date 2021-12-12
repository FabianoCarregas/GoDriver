package com.fabiano.moobi.Services;

import com.fabiano.moobi.Domain.TravelRequest;
import com.fabiano.moobi.Repositories.TravelRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TravelService {

    @Autowired
    private TravelRequestRepository travelRequestRepository;

    public TravelRequest saveTravelRequest(TravelRequest travelRequest) {
        return travelRequestRepository.save(travelRequest);
    }

}
