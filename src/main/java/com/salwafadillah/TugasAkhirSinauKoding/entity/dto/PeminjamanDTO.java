package com.salwafadillah.TugasAkhirSinauKoding.entity.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class PeminjamanDTO {
    private Long id;

    private Date tglPinjam;

    private Date tglKembali;

}
