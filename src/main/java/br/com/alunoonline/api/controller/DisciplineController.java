package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Discipline;
import br.com.alunoonline.api.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplinas")
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
    public Optional<Discipline> getProfessorById(@PathVariable Long id) {
        return disciplineService.getById(id);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deletedProfessor(@PathVariable Long id) {
        return disciplineService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatedProfessor(@PathVariable Long id, @RequestBody Discipline discipline){
        disciplineService.update(id, discipline);
    }

}
