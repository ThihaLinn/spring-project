package com.example.hotelbookingassignment.service;

import com.example.hotelbookingassignment.ds.Guest;
import com.example.hotelbookingassignment.repository.GuestDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuestRegistrationService {

    private final GuestDao guestDao;
    public Guest registerGuest(Guest guest) {
        return guestDao.save(guest);
    }
}
