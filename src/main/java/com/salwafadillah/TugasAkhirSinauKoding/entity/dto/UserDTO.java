package com.salwafadillah.TugasAkhirSinauKoding.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Long id;

    private String username;

    private  String password;

    private  String email;

    private String role;
}
