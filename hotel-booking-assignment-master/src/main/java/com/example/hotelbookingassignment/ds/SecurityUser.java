package com.example.hotelbookingassignment.ds;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SecurityUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role){
        role.getSecurityUsers().add(this);
        this.roles.add(role);
    }

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Guest guest;

    public SecurityUser(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
