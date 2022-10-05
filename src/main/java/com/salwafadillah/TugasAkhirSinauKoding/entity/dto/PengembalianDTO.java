package com.salwafadillah.TugasAkhirSinauKoding.entity.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PengembalianDTO {
    private Long id;

    private Date tglPengembalian;

    private Double denda;
}
