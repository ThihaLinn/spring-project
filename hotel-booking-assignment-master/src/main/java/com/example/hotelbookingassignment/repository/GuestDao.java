package com.example.hotelbookingassignment.repository;

import com.example.hotelbookingassignment.ds.Guest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GuestDao extends CrudRepository<Guest, Integer> {

    Optional<Guest> findGuestBySecurityUserName(String name);



}
