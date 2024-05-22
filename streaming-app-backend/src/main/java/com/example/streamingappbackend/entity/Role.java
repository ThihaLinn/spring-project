package com.example.streamingappbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String roleName;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Guest> guests = new HashSet<>();

    public void addGuest(Guest guest){
        guest.getRoles().add(this);
        guests.add(guest);
    }
    public Role(String roleName) {
        this.roleName = roleName;
    }
}
