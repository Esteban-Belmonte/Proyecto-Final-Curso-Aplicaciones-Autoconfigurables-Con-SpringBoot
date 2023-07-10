package repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

	@Query("SELECT e FROM Estudiante")
	List<Estudiante>findAllEstudiantes();
	
	@Query("SELECT e FROM Estudiante e WHERE e.dni > :dni AND e.apellido = :apellido")
	List<Estudiante> findByDniGreaterThanApellido(String dni, String Apellido);
	
	@Query("SELECT e FROM Estudiante e ORDER BY e.dni ASC")
	Page<Estudiante> findAllOrderByDni(Pageable pageable);
}
