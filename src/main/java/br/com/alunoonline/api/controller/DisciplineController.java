package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Discipline;
import br.com.alunoonline.api.service.DisciplineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplinas")
@Tag(name="Disciplina", description = "Endpoints para gerenciar disciplina")
public class DisciplineController {
    @Autowired
    DisciplineService disciplineService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Discipline discipline) {
        disciplineService.create(discipline);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Discipline> getAll() {
        return disciplineService.getAllDiscipline();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Discipline> getDisciplineById(@PathVariable Long id) {
        return disciplineService.getById(id);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deletedDiscipline(@PathVariable Long id) {
        return disciplineService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatedDiscipline(@PathVariable Long id, @RequestBody Discipline discipline){
        disciplineService.update(id, discipline);
    }
    @GetMapping("/professor/{professorId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Endpoint para listar disciplinas do professor")
    public List<Discipline> listarDisciplinasDoProf(@PathVariable Long professorId){
        return disciplineService.listarDisciplinaDoProf(professorId);
    }

}
