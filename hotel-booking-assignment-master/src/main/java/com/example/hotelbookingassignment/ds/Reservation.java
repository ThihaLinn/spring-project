package com.example.hotelbookingassignment.ds;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"room_id", "reservationDate"})})
@Getter
@Setter
@EqualsAndHashCode

@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private Room room;
    @ManyToOne(cascade = CascadeType.ALL)
    private Guest guest;
    private LocalDate reservationDate;

    public Reservation( LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }
}
