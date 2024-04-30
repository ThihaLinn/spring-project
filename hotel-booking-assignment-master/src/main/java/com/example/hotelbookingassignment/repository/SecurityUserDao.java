package com.example.hotelbookingassignment.repository;

import com.example.hotelbookingassignment.ds.SecurityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface SecurityUserDao extends JpaRepository<SecurityUser,Integer> {


    Optional<SecurityUser> findSecurityUserByNameOrderByGuest(String name);

    SecurityUser findSecurityUserByName(String name);
}
