package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.InstrutorDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.TurmaDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.InstrutorEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.TurmaEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");



    public List<TurmaDTO> listar() {
        List<TurmaEntity> listEntity = turmaRepository.findAll();
        List<TurmaDTO> listDTO = new ArrayList<>();

        for(TurmaEntity turmaEntity : listEntity){
            TurmaDTO turmaDTO = new TurmaDTO();
            turmaDTO.setDtInicio(turmaEntity.getDtInicio());
            turmaDTO.setDtFim(turmaEntity.getDtFinal());

            CursoEntity cursoEntities = turmaEntity.getCurso();
              CursoDTO  cursosDTO = new CursoDTO();
               CursoDTO curso = new CursoDTO();

                curso.setIdCurso(cursoEntities.getCurso());
                curso.setNome(cursoEntities.getNome());
                curso.setCargaHoraria(cursoEntities.getNrCargaHoraria());

            turmaDTO.setCurso(cursosDTO);

            List<InstrutorEntity> instrutorEntities = turmaEntity.getInstrutores();

            List<InstrutorDTO> instrutorDTOS = new ArrayList<>();

            for(InstrutorEntity instrutorEntity : instrutorEntities){
                InstrutorDTO instrutor = new InstrutorDTO();
                instrutor.setNome(instrutorEntity.getNomeInstrutor());
                instrutor.setValorHora(instrutorEntity.getValorHora());

                instrutorDTOS.add(instrutor);
            }

            turmaDTO.setInstrutores(instrutorDTOS);

            List<AlunoEntity> alunoEntities = turmaEntity.getAlunos();

            List<AlunoDTO> alunoDTOS = new ArrayList<>();

            for(AlunoEntity alunoEntity : alunoEntities){
                AlunoDTO aluno = new AlunoDTO();
                aluno.setNome(alunoEntity.getNomeAluno());
                aluno.setCpf(alunoEntity.getCpf());

                alunoDTOS.add(aluno);
            }


            turmaDTO.setAlunos(alunoDTOS);


        }

        return listDTO;
    }

}

