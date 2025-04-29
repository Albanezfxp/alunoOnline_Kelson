package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
}
