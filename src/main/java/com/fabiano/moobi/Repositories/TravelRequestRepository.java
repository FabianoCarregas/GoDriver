package com.fabiano.moobi.Repositories;

import com.fabiano.moobi.Domain.TravelRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelRequestRepository extends JpaRepository<TravelRequest, Long> {
}
