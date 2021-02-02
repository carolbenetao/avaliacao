package com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_CURSO")
@Data
public class CursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CURSO")
    private Long curso;

    @Column(name = "DS_CURSO")
    private String nome;

    @Column(name = "NR_CARGA_HORARIA")
    private Integer nrCargaHoraria;
}
