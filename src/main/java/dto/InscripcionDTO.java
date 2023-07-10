package dto;

import java.time.LocalDate;

import domain.EstadoInscripcion;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InscripcionDTO {

	
	private LocalDate fechaInscripcion;
	private EstadoInscripcion estado;
	private Long curso;
	private Long estudiante;
}
