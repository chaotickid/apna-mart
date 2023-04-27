package com.projkt.apnamart.model;
/**
 * Copyright © 2023 Mavenir Systems
 */

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Aditya Patil
 * @Date 27-04-2023
 */
public class CustomUserDetails implements UserDetails {
    private List<GrantedAuthority> authorityList;
    private String username;
    private String password;

    public CustomUserDetails(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "CustomUserDetails{" +
                "authorityList=" + authorityList +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
