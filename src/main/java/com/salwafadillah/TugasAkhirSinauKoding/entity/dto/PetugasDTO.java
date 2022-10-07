package com.salwafadillah.TugasAkhirSinauKoding.entity.dto;


import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class PetugasDTO {
    private Long id;

    private String namaPetugas;

    private String noTelp;

    private String alamat;

    private UserDTO user;
}
