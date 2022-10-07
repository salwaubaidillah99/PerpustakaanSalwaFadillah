package com.salwafadillah.TugasAkhirSinauKoding.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PengembalianDTO {
    private Long id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date tglPengembalian;

    private Double denda;

    private AnggotaDTO anggota;

    private PetugasDTO petugas;

}
