package service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import domain.Curso;
import dto.CursoDTO;
import java.util.Optional;
import java.util.stream.Collectors;
import repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
        /*
	public Curso findCurso(Long id) {
		Curso curso = cursoRepository.findById(id).orElse(null);
				return curso;
	}
	*/
        public CursoDTO find(Long id) {
            Optional<Curso> cursoOptional = cursoRepository.findById(id);
            
            if(cursoOptional.isEmpty()) {
                throw new RuntimeException("Id invalido");
            }
            
            Curso curso = cursoOptional.get();
            
            return new CursoDTO(curso.getNombre(), curso.getDescripcion(), curso.getFechaInicio(), curso.getFechaFinal());
        }
        
        
        /*
	public List<Curso> listarCursos() {
		return cursoRepository.findAllCursos();
	}
	*/
        
        public List<CursoDTO> findAll() {
		return cursoRepository.findAll()
				.stream().map(c -> new CursoDTO(c.getNombre(),c.getDescripcion(), c.getFechaInicio(), c.getFechaFinal()))
	            .collect(Collectors.toList());
	}
        
        /*
	@Transactional
	public void createCurso(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFinal) {
		Curso curso = new Curso();
		curso.setNombre(nombre);
		curso.setDescripcion(descripcion);
		curso.setFechaInicio(fechaInicio);
		curso.setFechaFinal(fechaFinal);
		
		cursoRepository.save(curso);
	}
	*/
        @Transactional
        public CursoDTO saveCurso(CursoDTO cursoDTO){
            Curso curso = new Curso(null,
            cursoDTO.getNombre(),
            cursoDTO.getDescripcion(),
            cursoDTO.getFechaInicio(),
            cursoDTO.getFechaFinal());
            
            cursoRepository.save(curso);
            return cursoDTO;
        }
        
        
	public void deleteCurso(Long id) {
		cursoRepository.findById(id)
		.orElseThrow(() -> new RuntimeException("Curso no encontrando"));
                cursoRepository.deleteById(id);
	}
	
        /*
	@Transactional
	 public void actualizarCurso(Long id, Curso cursoActualizado) {
	        Curso cursoExistente = cursoRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

	        cursoExistente.setNombre(cursoActualizado.getNombre());
	        cursoExistente.setDescripcion(cursoActualizado.getDescripcion());
	        cursoExistente.setFechaInicio(cursoActualizado.getFechaInicio());
	        cursoExistente.setFechaFinal(cursoActualizado.getFechaFinal());

	        cursoRepository.save(cursoExistente);
	}
	*/
        @Transactional
	public CursoDTO update(Long id, CursoDTO cursoDTO) {
		Curso curso = new Curso(id, cursoDTO.getNombre(), cursoDTO.getDescripcion(), cursoDTO.getFechaInicio(), cursoDTO.getFechaFinal());
		
		cursoRepository.save(curso);
		
		return cursoDTO;
	}
        
        
	public List<Curso> ListarCursosDespuesDeFecha(LocalDate fecha){
		return cursoRepository.findByFechaInicioAfter(fecha);
	}
	
	
	
	}