package com.salwafadillah.TugasAkhirSinauKoding.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "peminjamans")
@Getter
@Setter
public class Peminjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "integer")
    private  Long id;

    @Column
    private Date tglPinjam;

    @Column
    private Date tglKembali;

    @ManyToOne
    @JoinColumn(name = "id_anggota")
    private Anggota anggota;

    @ManyToOne
    @JoinColumn(name = "id_petugas")
    private Petugas petugas;

}
