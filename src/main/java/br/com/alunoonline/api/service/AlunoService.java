package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public void update(Long id, Aluno aluno) {
        Optional<Aluno> studentsInBd = alunoRepository.findById(id);

        if(studentsInBd.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }

        Aluno studentUpdated = studentsInBd.get();

        studentUpdated.setName(aluno.getName());
        studentUpdated.setCpf(aluno.getCpf());
        studentUpdated.setEmail(aluno.getEmail());

        alunoRepository.save(studentUpdated);

    }


}
