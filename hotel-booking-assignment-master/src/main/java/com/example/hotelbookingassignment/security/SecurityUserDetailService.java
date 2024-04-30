package com.example.hotelbookingassignment.security;

import com.example.hotelbookingassignment.repository.GuestDao;
import com.example.hotelbookingassignment.repository.SecurityUserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SecurityUserDetailService implements UserDetailsService {

    private final GuestDao guestDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return guestDao
                .findGuestBySecurityUserName(username)
                .map(SecurityUserDetail::new)
                .orElseThrow(() ->new UsernameNotFoundException("Error"));
    }
}
