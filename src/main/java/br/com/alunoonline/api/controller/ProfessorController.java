package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.service.ProfessorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professores")
@Tag(name="Professores", description = "Endpoints para gerenciar professores")

public class ProfessorController {


    @Autowired
    ProfessorService professorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Professor professor) {
        professorService.create(professor);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Professor> getAll() {
        return professorService.getAllProfessor();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Professor> getProfessorById(@PathVariable Long id) {
        return professorService.getProfessorById(id);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deletedProfessor(@PathVariable Long id) {
        return professorService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatedProfessor(@PathVariable Long id, @RequestBody Professor professor){
        professorService.update(id, professor);
    }


}
