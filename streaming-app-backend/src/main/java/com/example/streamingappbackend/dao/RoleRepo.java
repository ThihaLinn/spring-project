package com.example.streamingappbackend.dao;

import com.example.streamingappbackend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RoleRepo extends JpaRepository<Role,Integer> {

    Set<Role> findByRoleName (String name);



}
