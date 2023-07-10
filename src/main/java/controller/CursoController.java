package controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import domain.Curso;
import dto.CursoDTO;
import service.CursoService;



@RestController
@RequestMapping(value="/cursos")
public class CursoController {

	/*@Autowired
	private CursoService interCurso;
	
	@GetMapping("/lista")
	public List<Curso> listaCursos(){
		return interCurso.listarCursos();
	}
	
	@GetMapping("/lista/{fecha}")
	public List<Curso> ListarCursosDespuesDeFecha(@PathVariable LocalDate fecha){
		return interCurso.ListarCursosDespuesDeFecha(fecha);
	}
	
	@PostMapping("/crear")
	public String createCurso(@RequestBody Curso curso) {
		interCurso.createCurso(curso.getNombre(), curso.getDescripcion(), curso.getFechaInicio(), curso.getFechaFinal());
		return "El curso fue creado";
	}
	
	@DeleteMapping("/borrar/{id}")
	public String deleteCurso(@PathVariable Long id) {
		interCurso.deleteCurso(id);
		return "El curso fue eliminado correctamente";
	}
	
	@PutMapping("/editar/{id}")
	public Curso editCurso(@PathVariable Long id,
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("fechaInicio") LocalDate fechaInicio,
            @RequestParam("fechaInicio") LocalDate fechaFinal){
                    Curso curso = interCurso.findCurso(id);
                    curso.setNombre(nombre);
                    curso.setDescripcion(descripcion);
                    curso.setFechaInicio(fechaInicio);
                    curso.setFechaFinal(fechaFinal);

                    interCurso.createCurso(nombre, descripcion, fechaInicio, fechaFinal);
                     return curso;
}
	*/
    
    @Autowired
	private CursoService cursoService;
	
	@PostMapping("/crear")
	public CursoDTO save(@RequestBody CursoDTO cursoDTO) {
		return cursoService.saveCurso(cursoDTO);
	}
	
	@GetMapping("/lista")
	public List<CursoDTO>all() {
		return cursoService.findAll();
	}
	
	@GetMapping("/{id}")
	public CursoDTO find(@PathVariable Long id) {
		return cursoService.find(id);
	}
	
	 @PutMapping("/actualizar/{id}")
	    public CursoDTO update(@PathVariable Long id, @RequestBody CursoDTO cursoDTO) {
	        return cursoService.update(id, cursoDTO);
	    }

	 @DeleteMapping("/borrar/{id}")
	    public void delete(@PathVariable Long id) {
	        cursoService.deleteCurso(id);
	    }
    
}
