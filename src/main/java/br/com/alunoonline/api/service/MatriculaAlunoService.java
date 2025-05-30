package br.com.alunoonline.api.service;


import br.com.alunoonline.api.dtos.StudentHistoryResponseDTO;
import br.com.alunoonline.api.dtos.StudentSubjectsResponseDTO;
import br.com.alunoonline.api.dtos.UpdateGradesRequestDTO;
import br.com.alunoonline.api.enums.MatriculaAlunoStatusEnum;
import br.com.alunoonline.api.model.MatriculaAluno;
import br.com.alunoonline.api.repository.MatriculaAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MatriculaAlunoService {
    private static final Double MEDIA_PARA_APROVACAO = 7.0;
    private static final Integer QTD_NOTAS = 2;
    @Autowired
    MatriculaAlunoRepository matriculaAlunoRepository;

    public void criarMatricula(MatriculaAluno matriculaAluno) {
        matriculaAluno.setStatus(MatriculaAlunoStatusEnum.MATRICULADO);
        matriculaAlunoRepository.save(matriculaAluno);
    }

    public void trancarMatricula(Long matriculaAlunoId) {
        MatriculaAluno matriculaAluno = matriculaAlunoRepository.findById(matriculaAlunoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Matrícula Aluno não encontrada"));
        if (matriculaAluno.getStatus().equals(MatriculaAlunoStatusEnum.MATRICULADO)){
            matriculaAluno.setStatus(MatriculaAlunoStatusEnum.TRANCADO);
            matriculaAlunoRepository.save(matriculaAluno);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Só é possível trancar com o seu status matriculado.");
        }

    }
    public void atualizarNotas(Long matriculaAlunoId, UpdateGradesRequestDTO atualizarNotasRequestDTO){
        MatriculaAluno matriculaAluno = buscarMatriculaOuLancarExcecao(matriculaAlunoId);

        if(atualizarNotasRequestDTO.getNota1() != null){
            matriculaAluno.setNota1(atualizarNotasRequestDTO.getNota1());
        }
        if(atualizarNotasRequestDTO.getNota2() != null){
            matriculaAluno.setNota2(atualizarNotasRequestDTO.getNota2());
        }
        calcularMediaEModificarStatus(matriculaAluno);
        matriculaAlunoRepository.save(matriculaAluno);
    }

    public StudentHistoryResponseDTO emitirHistorico(Long alunoId){
        List<MatriculaAluno> matriculaAlunos = matriculaAlunoRepository.findByAlunoId(alunoId);
        if (matriculaAlunos.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Este aluno não possui matrículas.");
        }

        StudentHistoryResponseDTO historicoAluno = new StudentHistoryResponseDTO();
        historicoAluno.setNomeAluno(matriculaAlunos.get(0).getAluno().getName());
        historicoAluno.setEmailAluno(matriculaAlunos.get(0).getAluno().getEmail());
        historicoAluno.setCpfAluno(matriculaAlunos.get(0).getAluno().getCpf());

        List<StudentSubjectsResponseDTO> disciplinas = matriculaAlunos.stream()
                .map(this::mapearParaStudentHistoryResponseDTO)
                .toList();
        historicoAluno.setDisciplinas(disciplinas);
        return historicoAluno;
    }

    private MatriculaAluno buscarMatriculaOuLancarExcecao(Long matriculaAlunoId){
        return matriculaAlunoRepository.findById(matriculaAlunoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Matrícula do aluno não encontrada."));
    }

    private void calcularMediaEModificarStatus(MatriculaAluno matriculaAluno){
        Double nota1 = matriculaAluno.getNota1();
        Double nota2 = matriculaAluno.getNota2();

        if (nota1 != null && nota2 != null){
            Double media = (nota1 + nota2) / QTD_NOTAS;
            matriculaAluno.setStatus(media >= MEDIA_PARA_APROVACAO ? MatriculaAlunoStatusEnum.APROVADO : MatriculaAlunoStatusEnum.REPROVADO );
        }
    }

    private StudentSubjectsResponseDTO mapearParaStudentHistoryResponseDTO(MatriculaAluno matriculaAluno){
        StudentSubjectsResponseDTO response = new StudentSubjectsResponseDTO();
        response.setNomeDisciplina(matriculaAluno.getDisciplina().getName());
        response.setNomeProfessor(matriculaAluno.getDisciplina().getProfessor().getName());
        response.setNota1(matriculaAluno.getNota1());
        response.setNota2(matriculaAluno.getNota2());
        response.setMedia(calcularMedia(matriculaAluno.getNota1(), matriculaAluno.getNota2()));
        response.setStatus(matriculaAluno.getStatus());
        return response;
    }

    private Double calcularMedia(Double nota1, Double nota2){
        return (nota1 != null && nota2 != null) ? (nota1 + nota2) / QTD_NOTAS : null;
    }
}

