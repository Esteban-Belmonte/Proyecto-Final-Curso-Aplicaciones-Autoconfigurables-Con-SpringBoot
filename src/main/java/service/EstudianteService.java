package service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.EstudianteRepository;
import domain.Estudiante;
import dto.EstudianteDTO;

@Service
public class EstudianteService {
	
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	/*
	public List<Estudiante> listarEstudiantes() {
		return estudianteRepository.findAllEstudiantes();
	}
	*/
	
	public List<EstudianteDTO> findAll() {
		return estudianteRepository.findAll()
				.stream().map(e -> new EstudianteDTO(e.getNombre(),e.getApellido() , e.getDni(), e.getFechaNacimiento(), e.getEdad()))
	            .collect(Collectors.toList());
	}
	
	/*
	@Transactional
	public void createEstudiante(String nombre, String apellido, String dni, LocalDate fechaNacimiento){
		Estudiante estudiante = new Estudiante();
		estudiante.setNombre(nombre);
		estudiante.setApellido(apellido);
		estudiante.setDni(dni);
		estudiante.setFechaNacimiento(fechaNacimiento);
		estudianteRepository.save(estudiante);
	}
	*/
	@Transactional
	public EstudianteDTO saveEstudiante(EstudianteDTO estudianteDTO) {
		Estudiante estudiante = new Estudiante(
				null,
				estudianteDTO.getNombre(),
				estudianteDTO.getApellido(),
				estudianteDTO.getDni(),
				estudianteDTO.getFechaNacimiento(),
				estudianteDTO.getEdad()
				);
		
		estudianteRepository.save(estudiante);
		
		return estudianteDTO;
	}
	

	@Transactional
	public void deleteEstudiante(Long id) {
		estudianteRepository.findById(id).
		orElseThrow(() -> new RuntimeException("Estudiante no encontrando"));
		estudianteRepository.deleteById(id);
	}
	
	/*
	@Transactional
	public void actualizarEstudiante(Long id, Estudiante estudianteActualizado) {
		Estudiante estudianteExistente = estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        estudianteExistente.setNombre(estudianteActualizado.getNombre());
        estudianteExistente.setApellido(estudianteActualizado.getApellido());
        estudianteExistente.setDni(estudianteActualizado.getDni());
        estudianteExistente.setFechaNacimiento(estudianteActualizado.getFechaNacimiento());

        estudianteRepository.save(estudianteExistente);
	}

	*/
	@Transactional
	public EstudianteDTO update(Long id, EstudianteDTO estudianteDTO) {
		Estudiante estudiante = new Estudiante(id, estudianteDTO.getNombre(), estudianteDTO.getApellido(), estudianteDTO.getDni(), estudianteDTO.getFechaNacimiento(), estudianteDTO.getEdad());
		
		estudianteRepository.save(estudiante);
		
		return estudianteDTO;
	}
	
	public EstudianteDTO find(Long id) {
		Optional<Estudiante> estudianteOptional = estudianteRepository.findById(id);
		
		if (estudianteOptional.isEmpty()) {
			throw new RuntimeException("id invalido");
		}
		
		Estudiante estudiante = estudianteOptional.get();
		
		return new EstudianteDTO(estudiante.getNombre(), estudiante.getApellido(), estudiante.getDni(), estudiante.getFechaNacimiento(), estudiante.getEdad());
	}
	
	public List<Estudiante> listarEstudiantesPorDniYApellido(String dni, String apellido){
		return estudianteRepository.findByDniGreaterThanApellido(dni, apellido);
	}
	
	public Page<Estudiante> listarEstudiantesPaginacion(int pagina, int tamaño) {
        Pageable pageable = PageRequest.of(pagina, tamaño);
        return estudianteRepository.findAllOrderByDni(pageable);
    }
}
