package com.example.hotelbookingassignment.controller;

import com.example.hotelbookingassignment.ds.Reservation;
import com.example.hotelbookingassignment.repository.RoomDao;
import com.example.hotelbookingassignment.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController {

    private final RoomDao roomDao;

    private final BookingService bookingService;

    @GetMapping("/room-list")
    public String rooms(Model model){
        model.addAttribute("date",LocalDate.now());
        model.addAttribute("rooms",roomDao.findAll());
        model.addAttribute("reservation",new Reservation());
        return "rooms";
    }

    @PostMapping("/available-rooms")
    public String availableRoom(Model model, @RequestParam Optional<LocalDate> selectedDate){

        if(selectedDate.isEmpty()){
            return "redirect:/rooms/room-list";
        }
        selectedDate.ifPresent(r->bookingService.getAbout().setDate(r));

        selectedDate.ifPresent(d ->model.addAttribute("availableRoom",bookingService.findAvailableRoom(d)));
        model.addAttribute("date",selectedDate.orElse(LocalDate.now()));
        model.addAttribute("nowDate",LocalDate.now());

        return "availableRooms";
    }

}
