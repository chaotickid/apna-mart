package com.projkt.apnamart.repository;
/**
 * Copyright © 2023 Mavenir Systems
 */

import com.projkt.apnamart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Aditya Patil
 * @Date 27-04-2023
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
