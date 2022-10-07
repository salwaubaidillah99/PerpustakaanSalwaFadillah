package com.salwafadillah.TugasAkhirSinauKoding.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "penerbits")
@Getter
@Setter
public class Penerbit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "integer")
    private  Long id;

    @Column
    private String namaPenerbit;

    @Column
    private String noTelp;

    @Column
    private String alamat;


    @OneToMany(mappedBy = "penerbit")
    private List<Buku> bukuList;

}

