package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.EstadoInscripcion;
import domain.Inscripcion;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

	List<Inscripcion> findByEstadoInscripcionIn(List<EstadoInscripcion> estados);
	
	@Query(value = "SELECT * FROM inscripcion WHERE estado = :estado", nativeQuery = true)
	List<Inscripcion> findByEstado(String estado);
}
