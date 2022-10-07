package com.salwafadillah.TugasAkhirSinauKoding.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnggotaDTO {

    private Long id;

    private String namaAnggota;

    private String jenisKelamin;

    private String alamat;

    private String noTelp;

    private UserDTO user;
}
