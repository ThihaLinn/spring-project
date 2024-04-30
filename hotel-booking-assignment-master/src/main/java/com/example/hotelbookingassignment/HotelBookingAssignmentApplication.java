package com.example.hotelbookingassignment;

import com.example.hotelbookingassignment.ds.Guest;
import com.example.hotelbookingassignment.ds.Role;
import com.example.hotelbookingassignment.ds.Room;
import com.example.hotelbookingassignment.ds.SecurityUser;
import com.example.hotelbookingassignment.repository.GuestDao;
import com.example.hotelbookingassignment.repository.RoleDao;
import com.example.hotelbookingassignment.repository.RoomDao;
import com.example.hotelbookingassignment.repository.SecurityUserDao;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@RequiredArgsConstructor
public class HotelBookingAssignmentApplication {

    private final RoomDao roomDao;
    private final RoleDao roleDao;
    private final GuestDao guestDao;
    private final PasswordEncoder passwordEncoder;
    private final SecurityUserDao securityUserDao;

    // @Bean @Transactional
    public ApplicationRunner admin(){
        return r->{
            Guest guest = new Guest("Thiha","Linn");
            SecurityUser securityUser =new SecurityUser("ThihaLinn","linthiha964@gmail.com","thihalinn");
            Role role = new Role();
            role = roleDao.findRoleByRoleName("ADMIN");

            securityUser.setPassword(passwordEncoder.encode(securityUser.getPassword()));
            securityUser.addRole(role);
            securityUser.setGuest(guest);
            guest.setSecurityUser(securityUser);
            roleDao.save(role);

        };
    }

    //@Bean
    public ApplicationRunner addRole(){
        return  r->{
            Role admin = new Role();
            admin.setRoleName("ADMIN");
            roleDao.save(admin);

            Role user = new Role();
            user.setRoleName("USER");
            roleDao.save(user);
        };
    }

    //@Bean
    public ApplicationRunner runner(){
        return r->{
            Room room1 = new Room("001",'a',"/images/11.png","/images/12.png","/images/13.png");
            Room room2 = new Room("002",'b',"/images/21.png","/images/22.png","/images/23.png");
            Room room3 = new Room("003",'c',"/images/31.png","/images/32.png","/images/33.png");
            Room room4 = new Room("004",'d',"/images/41.png","/images/42.png","/images/43.png");
            Room room5 = new Room("005",'e',"/images/51.png","/images/52.png","/images/53.png");
            Room room6 = new Room("006",'f',"/images/61.png","/images/62.png","/images/63.png");
            Room room7 = new Room("007",'g',"/images/71.png","/images/72.png","/images/73.png");
            Room room8 = new Room("008",'h',"/images/81.png","/images/82.png","/images/83.png");
            Room room9 = new Room("009",'i',"/images/91.png","/images/92.png","/images/93.png");
            Room room10 = new Room("010",'j',"/images/101.png","/images/102.png","/images/103.png");
            Room room11 = new Room("011",'k',"/images/111.png","/images/112.png","/images/113.png");
            Room room12 = new Room("012",'l',"/images/121.png","/images/122.png","/images/123.png");
            roomDao.save(room1);
            roomDao.save(room2);
            roomDao.save(room3);
            roomDao.save(room4);
            roomDao.save(room5);
            roomDao.save(room6);
            roomDao.save(room7);
            roomDao.save(room8);
            roomDao.save(room9);
            roomDao.save(room10);
            roomDao.save(room11);
            roomDao.save(room12);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(HotelBookingAssignmentApplication.class, args);
    }

}
