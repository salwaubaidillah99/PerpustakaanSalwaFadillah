package com.salwafadillah.TugasAkhirSinauKoding.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "petugass")
@Getter
@Setter
public class Petugas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "integer")
    private  Long id;

    @Column
    private String namaPetugas;

    @Column
    private String noTelp;

    @Column
    private String alamat;

    @OneToMany(mappedBy = "petugas")
    private List<Peminjaman> peminjamanList;

    @OneToMany(mappedBy = "petugas")
    private List<Pengembalian> pengembalianList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
