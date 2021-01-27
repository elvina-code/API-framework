package com.devxschool.summer.pojo.fooddelivery;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRegistrationRequest {
    private int id;
    private String email;

    private String username;
    private String password;
    private String fullName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;


}
