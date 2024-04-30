package com.example.hotelbookingassignment.controller;

import com.example.hotelbookingassignment.repository.GuestDao;
import com.example.hotelbookingassignment.repository.ReservationDao;
import com.example.hotelbookingassignment.repository.SecurityUserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final ReservationDao reservationDao;
    private final SecurityUserDao securityUserDao;
    private final GuestDao guestDao;

    @GetMapping("/user-detail")
    public String userDetail(Model model,
                             Authentication authentication,
                             Principal principal){
        System.out.println("Before");

        model.addAttribute("guest",guestDao.findGuestBySecurityUserName(principal.getName()).orElseThrow());
        model.addAttribute("allReservation",reservationDao.findAll());
        model.addAttribute("reservation",reservationDao.findReservationByGuestSecurityUserNameOrderByReservationDateAsc(principal.getName()));

        return "userInfo";
    }

}
