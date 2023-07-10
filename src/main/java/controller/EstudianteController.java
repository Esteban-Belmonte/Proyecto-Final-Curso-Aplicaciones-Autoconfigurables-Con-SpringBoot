package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.EstudianteDTO;
import service.EstudianteService;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

	@Autowired
	private EstudianteService estudianteService;
	
	@PostMapping("/crear")
	public EstudianteDTO save(@RequestBody EstudianteDTO estudianteDTO) {
		return estudianteService.saveEstudiante(estudianteDTO);
	}
	
	@GetMapping("lista")
	public List<EstudianteDTO>all() {
		return estudianteService.findAll();
	}
	
	@GetMapping("/{id}")
	public EstudianteDTO find(@PathVariable Long id) {
		return estudianteService.find(id);
	}
	
	 @PutMapping("/actualizar/{id}")
	    public EstudianteDTO update(@PathVariable Long id, @RequestBody EstudianteDTO estudianteDTO) {
	        return estudianteService.update(id, estudianteDTO);
	    }

	 @DeleteMapping("/borrar/{id}")
	    public void delete(@PathVariable Long id) {
	        estudianteService.deleteEstudiante(id);
	    }
 
}
