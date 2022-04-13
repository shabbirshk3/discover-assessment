package com.discover.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.discover.model.entity.Passenger;



@Repository
public interface PassengerRepository extends JpaRepository<Passenger, String> {

}
