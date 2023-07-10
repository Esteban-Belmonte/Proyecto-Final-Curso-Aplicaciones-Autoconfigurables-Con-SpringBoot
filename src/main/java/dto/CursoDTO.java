package dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CursoDTO {

        private String nombre;
	private String descripcion;
	private LocalDate fechaInicio;
	private LocalDate fechaFinal;
}
