package com.fabiano.moobi.Repositories;

import com.fabiano.moobi.Domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {



}
