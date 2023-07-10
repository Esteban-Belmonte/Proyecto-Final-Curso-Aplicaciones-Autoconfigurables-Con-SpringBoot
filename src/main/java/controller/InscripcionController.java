
package controller;

import domain.EstadoInscripcion;
import dto.InscripcionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.InscripcionService;

@RestController
@RequestMapping("inscripcion")
public class InscripcionController {
    
    @Autowired
    private InscripcionService inscripcionService;
    
    @PostMapping("/crear")
    public void save(@RequestBody InscripcionDTO inscripcionDTO){
        inscripcionService.createInscripcion(inscripcionDTO.getFechaInscripcion(), inscripcionDTO.getEstado(), inscripcionDTO.getEstudiante(), inscripcionDTO.getCurso());
    }
    
}
