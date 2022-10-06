package com.salwafadillah.TugasAkhirSinauKoding.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "peminjamanDetail",
            joinColumns = @JoinColumn(name="peminjaman_id"),
            inverseJoinColumns = @JoinColumn(name ="buku_id"))
            Set<Peminjaman>detailPeminjaman=new HashSet<>();


}
