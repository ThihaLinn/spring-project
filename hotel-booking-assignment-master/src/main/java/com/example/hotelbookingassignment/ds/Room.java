package com.example.hotelbookingassignment.ds;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String name;
    private char section;

    private String imgOneUrl;
    private String imgTwoUrl;
    private String imgThreeUrl;

    @OneToMany(mappedBy = "room")
    private List<Reservation>  reservations = new ArrayList<>();

    public void addReservation(Reservation reservation){
        reservation.setRoom(this);
        reservations.add(reservation);
    }

    public Room(String name, char section, String imgOneUrl, String imgTwoUrl, String imgThreeUrl) {
        this.name = name;
        this.section = section;
        this.imgOneUrl = imgOneUrl;
        this.imgTwoUrl = imgTwoUrl;
        this.imgThreeUrl = imgThreeUrl;
    }
}
