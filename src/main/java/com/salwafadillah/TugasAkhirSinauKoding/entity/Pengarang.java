package com.salwafadillah.TugasAkhirSinauKoding.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pengarangs")
@Getter
@Setter
@NoArgsConstructor
public class Pengarang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BIGINT")
    private Long id;

    @Column
    private String namaPengarang;

    @Column
    private String noTelp;

    @Column
    private String alamat;

    @OneToMany(mappedBy = "pengarang")
    private List<Buku> bukuList;

}