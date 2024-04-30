package com.example.hotelbookingassignment.controller;

import com.example.hotelbookingassignment.ds.Guest;
import com.example.hotelbookingassignment.ds.Reservation;
import com.example.hotelbookingassignment.ds.Role;
import com.example.hotelbookingassignment.ds.SecurityUser;
import com.example.hotelbookingassignment.repository.GuestDao;
import com.example.hotelbookingassignment.repository.RoleDao;
import com.example.hotelbookingassignment.repository.SecurityUserDao;
import com.example.hotelbookingassignment.service.ApplicationService;
import com.example.hotelbookingassignment.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/guest")
public class GuestController {

    private final BookingService bookingService;
    private final ApplicationService applicationService;
    private final GuestDao guestDao;
    private final PasswordEncoder passwordEncoder;
    private final SecurityUserDao securityUserDao;
    private  final RoleDao roleDao;


    @PostMapping("/save-guest-and-booking")
    public String saveGuestAndBooking(SecurityUser securityUser,
                            @RequestParam String firstName,
                            @RequestParam String lastName){

        Guest guest = new Guest(firstName,lastName);
        applicationService.bookSpecificRoomForNewGuest(guest,
                securityUser,
                bookingService.getAbout().getName(),
                bookingService.getAbout().getDate());

        return "login";
    }

    @PostMapping("/save-guest")
    @Transactional
    public String saveGuest(SecurityUser securityUser,
                            @RequestParam String firstName,
                            @RequestParam String lastName){

        Guest guest = new Guest(firstName,lastName);
        securityUser.setPassword(passwordEncoder.encode(securityUser.getPassword()));
        Role role = roleDao.findRoleByRoleName("USER");
        securityUser.addRole(role);
        securityUser.setGuest(guest);
        guest.setSecurityUser(securityUser);
        securityUserDao.save(securityUser);

        return "login";
    }

    @PostMapping("/quick-booking")
    public String registerGuestAndBooking(@RequestParam String firstName,
                                          @RequestParam String lastName){

        applicationService.bookAnyRoomForNewGuest(firstName,lastName,bookingService.getAbout().getDate());
        return "redirect:/rooms/room-list";
    }

    @GetMapping("/quick-booking")
    public String register(){

        return "registerByAdmin";
    }

}
