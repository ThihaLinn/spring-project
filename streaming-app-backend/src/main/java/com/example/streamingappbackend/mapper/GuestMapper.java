package com.example.streamingappbackend.mapper;

import com.example.streamingappbackend.dto.GuestDto;
import com.example.streamingappbackend.entity.Guest;

public class GuestMapper {

    public static GuestDto toDto(Guest guest){
        return new GuestDto(
                guest.getId(),
                guest.getName(),
                guest.getGmail(),
                guest.getPassword(),
                guest.getStatus()
        );
    }

    public static Guest toEntity(GuestDto guestDto) {
        return new Guest(
                guestDto.name(),
                guestDto.gmail(),
                guestDto.password()
        );
    }
}
