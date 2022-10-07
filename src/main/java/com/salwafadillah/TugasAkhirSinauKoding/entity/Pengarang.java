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
    @Column(columnDefinition = "BIGINT(11)")
    private Long id;

    @Column(columnDefinition = "VARCHAR(30)")
    private String namaPengarang;

    @Column(columnDefinition = "VARCHAR(13)")
    private String noTelp;

    @Column(columnDefinition = "VARCHAR(100)")
    private String alamat;

    @OneToMany(mappedBy = "pengarang")
    private List<Buku> bukuList;

}