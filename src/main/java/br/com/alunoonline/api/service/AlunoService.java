package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class AlunoService {
    @Autowired
    AlunoRepository alunoRepository;

    public void create(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public List<Aluno> getAllStudent() {
       return alunoRepository.findAll();
    }

    public Optional<Aluno> getStudentById(Long id) {
        return alunoRepository.findById(id);
    }

    public String delete(Long id) {
        Optional<Aluno>alunoDeleted = alunoRepository.findById(id);
        if (alunoDeleted.isEmpty()) {
            return "Aluno não encontrado";
        }
        alunoRepository.delete(alunoDeleted.get());
        return "Aluno " + alunoDeleted.get().getName() + " deleteado";
    }


}
