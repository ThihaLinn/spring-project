package com.example.hotelbookingassignment.controller;

import com.example.hotelbookingassignment.repository.RoomDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final RoomDao roomDao;

    @RequestMapping({"/home", "/"})
    public String rooms(Model model){
        model.addAttribute("roomOneToFour",roomDao.findAll().stream().filter(r->r.getId()<=4));
        model.addAttribute("roomFiveToEight",roomDao.findAll().stream().filter(r-> 4<r.getId() && r.getId()<=8));
        model.addAttribute("roomAboveEight",roomDao.findAll().stream().filter(r-> r.getId()>8));
        return "home";
    }

}
