package service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Curso;
import domain.EstadoInscripcion;
import domain.Estudiante;
import domain.Inscripcion;
import repository.CursoRepository;
import repository.EstudianteRepository;
import repository.InscripcionRepository;

@Service
public class InscripcionService {

	@Autowired
	private InscripcionRepository inscripcionRepository;
	@Autowired
	private CursoRepository cursoRepository;
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	
	public List<Inscripcion> listarPorEstado(String estado){
		return inscripcionRepository.findByEstado(estado);
	}
	
	@Transactional
	public void createInscripcion(LocalDate fechaInscripcion, EstadoInscripcion estado, Long IdEstudiante, Long IdCurso) {
		Estudiante estudiante = estudianteRepository.findById(IdEstudiante)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        Curso curso = cursoRepository.findById(IdCurso)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
		
		Inscripcion inscripcion = new Inscripcion();
		inscripcion.setFechaInscripcion(fechaInscripcion);
		inscripcion.setEstado(estado);
		inscripcion.setEstudiante(estudiante);
		inscripcion.setCurso(curso);
		
		inscripcionRepository.save(inscripcion);
		
	}
	
}
