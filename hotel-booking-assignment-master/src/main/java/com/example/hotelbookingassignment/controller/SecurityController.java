package com.example.hotelbookingassignment.controller;

import com.example.hotelbookingassignment.ds.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/security")
public class SecurityController {

    @GetMapping("/login")
    public String login(){

        return "login";
    }

    @GetMapping("/sign-up")
    public String signup(Model model){
        model.addAttribute("sec",new SecurityUser());
        return "signup";
    }

    @GetMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("loginError",true);
        return "login";
    }

}
