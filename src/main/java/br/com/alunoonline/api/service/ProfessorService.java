package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.repository.AlunoRepository;
import br.com.alunoonline.api.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    ProfessorRepository professorRepository;

    public void create(Professor professor) {
        professorRepository.save(professor);
    }

    public List<Professor> getAllProfessor() {return professorRepository.findAll();}

    public Optional<Professor> getProfessorById(Long id) {
        return professorRepository.findById(id);
    }

    public String delete(Long id) {
        Optional<Professor> professorDeleted = professorRepository.findById(id);
        if (professorDeleted.isEmpty()) {
            return "Professor não encontrado";
        }
        professorRepository.delete(professorDeleted.get());
        return "Professor: " + professorDeleted.get().getName() + " deletado.";
    }
    
    public void update(Long id, Professor professor) {
        Optional<Professor> professorId = professorRepository.findById(id);
        
        if (professorId.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor not found");
        }
        
        Professor professorUpdated = professorId.get();

        professorUpdated.setName(professor.getName());
        professorUpdated.setCpf(professor.getCpf());
        professorUpdated.setEmail(professor.getEmail());

        professorRepository.save(professorUpdated);
    }

}
