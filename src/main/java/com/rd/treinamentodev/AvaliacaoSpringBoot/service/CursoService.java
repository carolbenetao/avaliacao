package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CursoService {


    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    public String cadastrarCurso(CursoDTO cursoDTO) {
        CursoEntity entity = new CursoEntity();

        entity.setNome(cursoDTO.getNome());
        entity.setNrCargaHoraria(cursoDTO.getCargaHoraria());

        cursoRepository.save(entity);

        return "Cadastro realizado com sucesso!";
    }

}
