package com.example.hotelbookingassignment.ds;

import jakarta.persistence.*;
import lombok.*;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "guest",cascade =CascadeType.ALL)
    private Set<Reservation> reservations = new HashSet<>();

    @OneToOne(orphanRemoval = true,cascade = CascadeType.ALL)
    private SecurityUser securityUser;

    public void addReservation(Reservation reservation){
        reservation.setGuest(this);
        reservations.add(reservation);
    }

    public Guest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}



