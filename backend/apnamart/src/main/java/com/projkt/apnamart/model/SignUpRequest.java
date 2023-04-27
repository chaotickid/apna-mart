package com.projkt.apnamart.model;
/**
 * Copyright © 2023 Mavenir Systems
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Aditya Patil
 * @Date 27-04-2023
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

    private String username;
    private String password;
}
