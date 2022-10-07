package com.salwafadillah.TugasAkhirSinauKoding.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pengembalians")
@Getter
@Setter
public class Pengembalian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "integer")
    private  Long id;

    @Column
    private Date tglPengembalian;

    @Column
    private Double denda;

    @ManyToOne
    @JoinColumn(name = "id_anggota")
    private Anggota anggota;

    @ManyToOne
    @JoinColumn(name = "id_petugas")
    private Petugas petugas;

}