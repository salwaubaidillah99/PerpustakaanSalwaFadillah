package com.salwafadillah.TugasAkhirSinauKoding.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bukus")
@Getter
@Setter
@NoArgsConstructor
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "integer")
    private Long id;


    private String judul;

    @Column
    private String tahunTerbit;

    @Column
    private Integer jumlah;

    @Column
    private String isbn;
    @ManyToOne
    @JoinColumn(name = "id_pengarang")
    private Pengarang pengarang;

    @ManyToOne
    @JoinColumn(name = "id_penerbit")
    private Penerbit penerbit;

    @JsonIgnore
    @ManyToMany(mappedBy = "detailPeminjaman")
    private Set<Peminjaman> peminjaman = new HashSet<>();

}