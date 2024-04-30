package com.example.hotelbookingassignment.repository;


import com.example.hotelbookingassignment.ds.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface RoomDao extends CrudRepository<Room, Integer> {

    Set<Room> findAll();

    Room findByName(String name);
}
