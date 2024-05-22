package com.example.streamingappbackend.controller;

import com.example.streamingappbackend.dto.GuestDto;
import com.example.streamingappbackend.dto.LoginDto;
import com.example.streamingappbackend.entity.Guest;
import com.example.streamingappbackend.mapper.GuestMapper;
import com.example.streamingappbackend.response.LoginResponse;
import com.example.streamingappbackend.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/guest")
public class GuestController {

    private final GuestService guestService;

    @GetMapping("{gmail}")
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<GuestDto> getGuest(@PathVariable String gmail){
        System.out.println(gmail);
        var result =guestService.findGuestByGmail(gmail);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/guest-list")
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<GuestDto>> guestList(){
        var result =guestService.allGuest();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/register")
    @PreAuthorize("permitAll()")
    public ResponseEntity<String> registerGuest(@RequestBody GuestDto guestDto){
        guestService.registerGuest(guestDto);
        return ResponseEntity.ok("Successfully Created");
    }

    @PostMapping("/login")
    @PreAuthorize("permitAll()")
    public ResponseEntity<LoginResponse> Login(@RequestBody LoginDto loginDto){
        var result = guestService.login(loginDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/guest-list/{gmail}")
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Boolean> get(@PathVariable String gmail){
        var result = guestService.getGuest(gmail);
        return ResponseEntity.ok(result);
    }

    @GetMapping({"/status/{name}"})
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Boolean> getStatus(@PathVariable String name){
        var result = guestService.getStatus(name);
        return ResponseEntity.ok(result);
    }

    @GetMapping({"/status/change-status/{id}"})
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> changeStatus(@PathVariable Integer id){
        var guest = guestService.changeStatus(id);
        System.out.println(guest);
        return ResponseEntity.ok("Changed successfully");
    }

    @GetMapping({"/status/get-status/{gmail}"})
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Boolean> checkStatus(@PathVariable String gmail){
        System.out.println(gmail);
        var result = guestService.giveStatus(gmail);
        return ResponseEntity.ok(result);
    }


}
