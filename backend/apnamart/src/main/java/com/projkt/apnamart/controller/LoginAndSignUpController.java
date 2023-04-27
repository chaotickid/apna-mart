package com.projkt.apnamart.controller;
/**
 * Copyright © 2023 Mavenir Systems
 */

import com.projkt.apnamart.model.User;
import com.projkt.apnamart.service.UserService;
import com.projkt.apnamart.utils.JwtUtils;
import com.projkt.apnamart.model.SignInRequest;
import com.projkt.apnamart.security.CustomUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aditya Patil
 * @Date 27-04-2023
 */

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class LoginAndSignUpController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody SignInRequest signInRequest) throws AuthenticationException {
        System.out.println("Hitting");
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    signInRequest.getUsername(), signInRequest.getPassword()
            ));
        } catch (Exception e) {
            log.debug("BAD CREDENTIALS: Authentication failed: " + e);
            throw new AuthenticationException("Invalid credentials, please try again.");
        }
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(signInRequest.getUsername());
        String jwtToken = jwtUtils.generateToken(userDetails);
        SignInRequest signInRequest1 = new SignInRequest();
        signInRequest1.setUsername(signInRequest.getUsername());
        signInRequest1.setJwtToken(jwtToken);
        return new ResponseEntity<>(signInRequest1, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignInRequest signInRequest) {
        User user = new User();
        user.setUsername(signInRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signInRequest.getPassword()));
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }
}
