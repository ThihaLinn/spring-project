package com.example.streamingappbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LoginDto(

        @JsonProperty("name_or_email")
        String nameOrEmail,
        String password
) {
}
