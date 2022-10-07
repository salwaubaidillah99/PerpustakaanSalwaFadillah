package com.salwafadillah.TugasAkhirSinauKoding.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class PeminjamanDTO {
    private Long id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date tglPinjam;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date tglKembali;

    private AnggotaDTO anggota;

    private PetugasDTO petugas;


}
