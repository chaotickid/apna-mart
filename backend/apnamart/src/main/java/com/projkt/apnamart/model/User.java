package com.projkt.apnamart.model;
/**
 * Copyright © 2023 Mavenir Systems
 */

import lombok.Data;

import javax.persistence.*;

/**
 * @author Aditya Patil
 * @Date 27-04-2023
 */

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String username;

    private String password;

}
