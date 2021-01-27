package com.devxschool.summer.pojo.gorest;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserData {
    private String id;
    private String name;
    private String email;
    private String gender;
    private String status;
}
