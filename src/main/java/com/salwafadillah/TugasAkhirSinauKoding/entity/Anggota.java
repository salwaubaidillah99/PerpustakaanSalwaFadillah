package com.salwafadillah.TugasAkhirSinauKoding.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "anggotas")
@Getter
@Setter
public class Anggota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "integer")
    private  Long id;

    @Column
    private String namaAnggota;

    @Column
    private String jenisKelamin;

    @Column
    private String alamat;

    @Column
    private String noTelp;

    @OneToMany(mappedBy = "anggota")
    private List<Peminjaman> peminjamanList;

    @OneToMany(mappedBy = "anggota")
    private List<Pengembalian> pengembalianList;

}
