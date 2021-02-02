package com.rd.treinamentodev.AvaliacaoSpringBoot.repository;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<CursoEntity, Long> {

    List<CursoEntity> findByNome(String nome); // SELECT * FROM TB_CURSO WHERE DS_NOME = ???

}
