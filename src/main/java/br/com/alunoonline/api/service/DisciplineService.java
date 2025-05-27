package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.model.Discipline;
import br.com.alunoonline.api.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplineService {
    @Autowired
    DisciplineRepository DisciplineRepository;
    @Autowired
    private DisciplineRepository disciplineRepository;

    public List<Discipline> getAllDiscipline() {
        return DisciplineRepository.findAll();
    }

    public Optional<Discipline> getById(Long id) {
        Optional<Discipline> discipline = DisciplineRepository.findById(id);

        if (discipline.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Discipline not found");
        }
        return discipline;
    }

    public void create(Discipline discipline){
        DisciplineRepository.save(discipline);
    }

    public String delete(Long id) {
        Optional<Discipline>DisciplineDeleted = DisciplineRepository.findById(id);
        if (DisciplineDeleted.isEmpty()) {
            return "Disciplina não encontrada";
        }
        DisciplineRepository.delete(DisciplineDeleted.get());
        return "Disciplina " + DisciplineDeleted.get().getName() + " deleteada";
    }

    public void update(Long id, Discipline discipline) {
        Optional<Discipline> disciplineId = DisciplineRepository.findById(id);

        if(disciplineId.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Discipline not found");
        }

        Discipline disciplineDeleted = disciplineId.get();

        disciplineDeleted.setName(discipline.getName());
        disciplineDeleted.setCargaHoraria(discipline.getCargaHoraria());
        disciplineDeleted.setProfessor(discipline.getProfessor());

        DisciplineRepository.save(disciplineDeleted);

    }
    public List<Discipline> listarDisciplinaDoProf(Long professorId){
        return disciplineRepository.findByProfessorId(professorId);
    }


}
