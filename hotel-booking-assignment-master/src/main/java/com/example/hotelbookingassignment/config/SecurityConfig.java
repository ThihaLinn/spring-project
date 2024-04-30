package com.example.hotelbookingassignment.config;

import com.example.hotelbookingassignment.security.SecurityUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final SecurityUserDetailService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.formLogin(c ->{
            c.loginPage("/login")
                    .successForwardUrl("/")
                    .failureUrl("/security/login-error")
                    .permitAll();
        });
        http.logout( c -> {
            c.logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                    .permitAll();
        });

        http.authorizeHttpRequests( r ->
                r.requestMatchers("/","/home","/rooms/**",
                                "/bootstrap/**","/register/**",
                                "/guest/**","/security/**",
                                "/images/**")
                        .permitAll()
                        .anyRequest().authenticated()

        );

            http.csrf(r->r.disable());
        return http.build();
    }


}
