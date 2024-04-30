package com.example.hotelbookingassignment.repository;

import com.example.hotelbookingassignment.ds.Reservation;
import com.example.hotelbookingassignment.ds.Room;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface ReservationDao extends CrudRepository<Reservation, Integer> {

    Set<Reservation> findAllByReservationDate(LocalDate reservationDate);

    boolean existsByRoomAndReservationDate(Room room, LocalDate reservationDate);

    List<Reservation> findReservationByGuestSecurityUserNameOrderByReservationDateAsc(String name);
}
