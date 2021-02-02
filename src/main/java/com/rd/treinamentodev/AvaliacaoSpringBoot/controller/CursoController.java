package com.rd.treinamentodev.AvaliacaoSpringBoot.controller;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoController {

    @Autowired
    CursoService service;

    @PostMapping("/curso")
    public ResponseEntity cadastrarCurso(@RequestBody CursoDTO cursoDTO) {

        if(cursoDTO.getNome() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Atributo nome do curso é obrigatório");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarCurso(cursoDTO));
    }

}
