package com.projkt.apnamart.security;
/**
 * Copyright © 2023 Mavenir Systems
 */

import com.projkt.apnamart.model.CustomUserDetails;
import com.projkt.apnamart.model.User;
import com.projkt.apnamart.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Aditya Patil
 * @Date 27-04-2023
 */
@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("Username: " + username);
        User user = userRepository.findByUsername(username);
        System.out.println("User: " + user);
        if (null == user) {
            log.debug("User is not found");
            return null;
            //throw new UsernameNotFoundException("User not found");
        }
        System.out.println("User password: "+ user.getPassword());
        CustomUserDetails customUserDetails = new CustomUserDetails(user);
        System.out.println("Customer userdetails: "+ customUserDetails);
        return customUserDetails;
    }
}
