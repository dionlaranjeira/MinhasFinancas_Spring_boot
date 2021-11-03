package com.minhasfinancas.MinhasFinancas.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name= "usuario", schema = "financas")
@Data
public class Usuario {

    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name= "nome")
    private  String nome;

    @Column(name= "email")
    private String email;

    @Column(name= "senha")
    private  String senha;

}
