package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
    List<Discipline> findByProfessorId(Long professorId);

}
