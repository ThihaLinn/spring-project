package com.example.hotelbookingassignment.service;

import com.example.hotelbookingassignment.ds.Guest;
import com.example.hotelbookingassignment.ds.Reservation;
import com.example.hotelbookingassignment.ds.Room;
import com.example.hotelbookingassignment.dto.About;
import com.example.hotelbookingassignment.repository.ReservationDao;
import com.example.hotelbookingassignment.repository.RoomDao;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.naming.Name;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class BookingService {


    private final ReservationDao reservationDao;
    private final RoomDao roomDao;

     About about = new About();


    public Set<Room> findAvailableRoom(LocalDate date) {

        var reservations=reservationDao.findAllByReservationDate(date);
        var notAvailableRoom =reservations.stream().map(r->r.getRoom()).collect(Collectors.toSet());
        var allRooms = roomDao.findAll();
        Set<Room> availableRoom = new HashSet(allRooms);
        availableRoom.removeAll(notAvailableRoom);

        return availableRoom;

    }

    public Reservation bookRoom(String roomName, Guest guest, LocalDate date) {
        Room room=roomDao.findByName(roomName);
        Reservation reservation = new Reservation(date);
        reservation.setRoom(room);
        reservation.setGuest(guest);
        return reservation;
    }

    public Reservation bookRoom(Room room, Guest guest, LocalDate date) {
        Reservation reservation = new Reservation(date);
        reservation.setGuest(guest);
        reservation.setRoom(room);
        return reservation;
    }

    public boolean isRoomAvailableAtDate(Room room, LocalDate date) {
        return reservationDao.existsByRoomAndReservationDate(room,date);
    }





}
