package com.example.lab1ta.services.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private String userName;
    private String password;
}
