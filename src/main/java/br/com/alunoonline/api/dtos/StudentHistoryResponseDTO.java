package br.com.alunoonline.api.dtos;

import lombok.Data;

import java.util.List;

@Data
public class StudentHistoryResponseDTO {
    private String nomeAluno;
    private String emailAluno;
    private String cpfAluno;
    private List<StudentSubjectsResponseDTO> disciplinas;
}
