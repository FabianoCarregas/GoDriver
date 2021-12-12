package com.fabiano.moobi.Repositories;

import com.fabiano.moobi.Domain.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
