package com.example.hotelbookingassignment.service;

import com.example.hotelbookingassignment.ds.*;


import com.example.hotelbookingassignment.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final GuestRegistrationService guestRegistrationService;

    private final BookingService bookingService;

    private final ReservationDao reservationDao;

    private final GuestDao guestDao;

    private final RoomDao roomDao;

    private final PasswordEncoder passwordEncoder;

    private final RoleDao roleDao;

    private final SecurityUserDao securityUserDao;

    private BookingResult bookingResult;

    public void bookAnyRoomForNewGuest(String firstName, String lastName,LocalDate date) {
        Optional<Room> room = bookingService.findAvailableRoom(date).stream().findFirst();
        Reservation reservation = new Reservation(date);
        Guest guest =new Guest(firstName,lastName);

            room.ifPresent(r->{
                reservation.setRoom(r);
                reservation.setGuest(guest);
                reservationDao.save(reservation);
            });
            //return BookingResult.createRoomBookedResult(reservation);
    }

    public Guest registerGuest(String firstName, String lastName) {
        Guest guest = new Guest(firstName,lastName);
        return guestRegistrationService.registerGuest(guest);
    }

    public String bookAnyRoomForRegisteredGuest(LocalDate date,Room room) {

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Guest guest =guestDao.findGuestBySecurityUserName(authentication.getName()).orElseThrow();

            Reservation reservation = new Reservation(date);
            reservation.setGuest(guest);

            reservation.setRoom(room);
            reservationDao.save(reservation);

            //return BookingResult.createNoRoomAvailableResult();
            return room.getName();
    }

    public void  bookSpecificRoomForRegisteredGuest( String roomName, LocalDate date) {
        var room =roomDao.findByName(roomName);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Guest guest =guestDao.findGuestBySecurityUserName(authentication.getName()).orElseThrow();

        Reservation reservation = new Reservation(date);
        reservation.setGuest(guest);
        reservation.setRoom(room);

        reservationDao.save(reservation);

        //return BookingResult.createRoomBookedResult(reservation);

    }
    @Transactional
    public void bookSpecificRoomForNewGuest(Guest guest, SecurityUser securityUser, String roomName, LocalDate date) {
        var room =roomDao.findByName(roomName);
        System.out.println(room);
        Role role;

        role = roleDao.findRoleByRoleName("USER");

        securityUser.setPassword(passwordEncoder.encode(securityUser.getPassword()));
        securityUser.addRole(role);
        securityUser.setGuest(guest);
        securityUserDao.save(securityUser);


        guest.setSecurityUser(securityUser);

        Reservation reservation = new Reservation(date);
        reservation.setGuest(guest);
        reservation.setRoom(room);

        reservationDao.save(reservation);


        //return BookingResult.createRoomBookedResult(reservation);

    }
}
