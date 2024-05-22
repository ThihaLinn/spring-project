package com.example.streamingappbackend.security;

import com.example.streamingappbackend.dao.GuestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityUserDetailService implements UserDetailsService {

    private final GuestRepo guestRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return guestRepo
                .findGuestByNameOrGmail(username,username)
                .map(SecurityUserDetail::new)
                .orElseThrow(() ->new UsernameNotFoundException("Error"));
    }
}
