package com.projkt.apnamart.service;
/**
 * Copyright © 2023 Mavenir Systems
 */

import com.projkt.apnamart.model.User;
import com.projkt.apnamart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Aditya Patil
 * @Date 27-04-2023
 */

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

}
