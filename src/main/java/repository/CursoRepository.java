package repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

	@Query("SELECT c FROM Curso")
	List<Curso> findAllCursos();
	
	@Query("SELECT c FROM Curso c WHERE c.fechaInicio > :fecha")
	List<Curso> findByFechaInicioAfter(LocalDate fecha);
	
}
