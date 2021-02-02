package com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class CursoDTO {

    private Long idCurso;

    private String nome;

    private Integer cargaHoraria;
}
