package com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TurmaDTO {

    private CursoDTO curso;

    private Date dtInicio;

    private Date dtFim;

    private List<InstrutorDTO> instrutores;

    private List<AlunoDTO> alunos;
}
