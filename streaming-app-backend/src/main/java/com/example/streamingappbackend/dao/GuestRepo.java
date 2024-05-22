package com.example.streamingappbackend.dao;

import com.example.streamingappbackend.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GuestRepo extends JpaRepository<Guest,Integer> {

    Optional<Guest> findGuestByNameOrGmail(String name, String gmail);

    Guest findGuestByName(String name);

    Boolean existsGuestByNameOrGmailAndPassword(String name,String gmail,String password);

    Boolean existsByGmail(String gmail);

    Optional<Guest> findGuestByGmail(String gmail);

    @Query("update Guest g set g.status = ?1 where g.id = ?2")
    void updateGuestByStatus(Boolean status,Integer id);

}
