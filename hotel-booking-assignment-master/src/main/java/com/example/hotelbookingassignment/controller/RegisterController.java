package com.example.hotelbookingassignment.controller;

import com.example.hotelbookingassignment.ds.Guest;
import com.example.hotelbookingassignment.ds.Room;
import com.example.hotelbookingassignment.ds.SecurityUser;
import com.example.hotelbookingassignment.repository.RoomDao;
import com.example.hotelbookingassignment.service.ApplicationService;
import com.example.hotelbookingassignment.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegisterController {

    private final RoomDao roomDao;
    private final BookingService bookingService;
    private final ApplicationService applicationService;

    @GetMapping("/book")
    public String Register( @RequestParam String name,
                            Authentication authentication,
                            Model model,
                            Principal principal){
        bookingService.getAbout().setName(name);
        if(authentication !=null && authentication.isAuthenticated()){
            return "redirect:/register/booking";
        }

        model.addAttribute("guest",new Guest());
        model.addAttribute("secUser",new SecurityUser());


        return "registerForNotLogin";
    }

    @GetMapping("booking")
    public String Booking (Model model){
        model.addAttribute("date",bookingService.getAbout().getDate());
        model.addAttribute("room",bookingService.getAbout().getName());
        model.addAttribute("id",2);

        return "registerForLogin";
    }

    @PostMapping("/save-booking")
    public String saveBooking(@RequestParam String roomName,
                              @RequestParam LocalDate date,
                              @RequestParam int id){

        if(id==1){
            applicationService.bookSpecificRoomForRegisteredGuest(roomName,date);
            System.out.println("check");
        }else if(id==2){
            applicationService.bookAnyRoomForRegisteredGuest(date,roomDao.findByName(roomName));
            System.out.println("Any");
        }

        return "redirect:/home";
    }

    @GetMapping("/quick-booking")
    public String quickBooking(Model model){
        var date = bookingService.getAbout().getDate();

       Room room = bookingService.findAvailableRoom(date).stream().findFirst().orElseThrow();
       model.addAttribute("room",room.getName());
       model.addAttribute("date",date);
       model.addAttribute("id",2);

    return "registerForLogin";

    }

}
