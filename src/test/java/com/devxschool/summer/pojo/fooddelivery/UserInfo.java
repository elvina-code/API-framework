package com.devxschool.summer.pojo.fooddelivery;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class UserInfo {
    private String password;
    private String username;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean enabled;

    private List<Authority> authorities; // array

    private UserRegistrationRequest userProfile; // simple object



}
