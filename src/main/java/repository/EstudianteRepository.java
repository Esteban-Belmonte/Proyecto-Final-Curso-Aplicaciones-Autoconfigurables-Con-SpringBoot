package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

}
