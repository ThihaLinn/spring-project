package com.example.streamingappbackend.service;

import com.example.streamingappbackend.dao.GuestRepo;
import com.example.streamingappbackend.dao.RoleRepo;
import com.example.streamingappbackend.dto.GuestDto;
import com.example.streamingappbackend.dto.LoginDto;
import com.example.streamingappbackend.entity.Guest;
import com.example.streamingappbackend.mapper.GuestMapper;
import com.example.streamingappbackend.response.LoginResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.streamingappbackend.mapper.GuestMapper.*;

@Service
@RequiredArgsConstructor
public class GuestService {

    private final GuestRepo guestRepo;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepo roleRepo;

    public void registerGuest(GuestDto guestDto){
            var guest = toEntity(guestDto);
            guest.setPassword(passwordEncoder.encode(guestDto.password()));

            var admin = roleRepo.findByRoleName("ROLE_ADMIN");
            var user = roleRepo.findByRoleName("ROLE_USER");

            if(guestRepo.existsByGmail(guestDto.gmail())){
                return;
            }

        if (guest.getGmail().equals("linthiha964@gmail.com")) {
            guest.setRoles(admin);
            guest.setStatus(true);

        } else {
            guest.setRoles(user);
            guest.setStatus(false);

        }

        guestRepo.save(guest);
    }
    public List<GuestDto> allGuest(){
      return  guestRepo.findAll()
              .stream()
              .map(GuestMapper::toDto)
              .collect(Collectors.toList());
    }

    public LoginResponse login(LoginDto loginDto) {

        if(loginDto.nameOrEmail().isEmpty() || loginDto.nameOrEmail().isBlank()){
            return new LoginResponse("Email can't be null",false);
        }

        if(loginDto.password().isEmpty() || loginDto.password().isBlank()){
            return new LoginResponse("Password can't be null",false);
        }

        if(!guestRepo.existsGuestByNameOrGmailAndPassword(loginDto.nameOrEmail(),loginDto.nameOrEmail(), passwordEncoder.encode(loginDto.password()))){
           return new LoginResponse("Invalid Credentials",false);
        }

        return new LoginResponse("Authentication successful",true);

    }

    public Boolean getGuest(String gmail){
        return guestRepo.existsByGmail(gmail);
    }

    public Boolean getStatus(String name){
         var guest = guestRepo.findGuestByName(name);
         return  guest.getStatus();
    }

    public Boolean giveStatus(String gmail){
        var guest = new Guest();
        if(guestRepo.existsByGmail(gmail)){
             guest  = guestRepo.findGuestByGmail(gmail).get();
        }
        return guest.getStatus();
    }

    @Transactional
    public GuestDto changeStatus(Integer id){
        var guest = guestRepo.findById(id).orElseThrow();
        guest.setStatus(!guest.getStatus());
        guestRepo.save(guest);
        System.out.println( guest.getStatus().equals(guestRepo.findById(id).get().getStatus()));
        return toDto(guest);
    }

    public GuestDto findGuestByGmail(String gmail){
        return  toDto(guestRepo.findGuestByGmail(gmail).orElseThrow());
    }

}
