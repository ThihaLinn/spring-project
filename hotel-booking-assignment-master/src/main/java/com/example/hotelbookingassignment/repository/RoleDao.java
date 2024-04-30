package com.example.hotelbookingassignment.repository;

import com.example.hotelbookingassignment.ds.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleDao extends JpaRepository<Role,Integer> {

    Role findRoleByRoleName(String name);

}
