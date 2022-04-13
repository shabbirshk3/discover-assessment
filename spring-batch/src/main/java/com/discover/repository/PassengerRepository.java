package com.discover.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.discover.model.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
}
