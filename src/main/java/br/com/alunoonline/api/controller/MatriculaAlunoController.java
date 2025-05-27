package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.dtos.StudentHistoryResponseDTO;
import br.com.alunoonline.api.dtos.UpdateGradesRequestDTO;
import br.com.alunoonline.api.model.MatriculaAluno;
import br.com.alunoonline.api.service.MatriculaAlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matriculas")
@Tag(name="Matriculas", description = "Endpoints para gerenciar Matriculas")

public class MatriculaAlunoController {

    @Autowired
    MatriculaAlunoService matriculaAlunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Endpoint para criar matrícula")
    public void criarMatricula(@RequestBody MatriculaAluno matriculaAluno){
        matriculaAlunoService.criarMatricula(matriculaAluno);
    }

    @PatchMapping("/trancar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Endpoint para trancar matrícula")
    public void trancarMatricula(@PathVariable Long id){
        matriculaAlunoService.trancarMatricula(id);
    }


    @PatchMapping("/atualizar-notas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Endpoint para atualizar notas")
    public void atualizarNotas(@PathVariable Long id, @RequestBody UpdateGradesRequestDTO atualizarNotasRequestDTO){
        matriculaAlunoService.atualizarNotas(id, atualizarNotasRequestDTO);
    }

    @GetMapping("/emitir-historico/{alunoId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Endpoint para emitir histórico")
    public StudentHistoryResponseDTO emitirHistorico(@PathVariable Long alunoId){
        return matriculaAlunoService.emitirHistorico(alunoId);
    } }