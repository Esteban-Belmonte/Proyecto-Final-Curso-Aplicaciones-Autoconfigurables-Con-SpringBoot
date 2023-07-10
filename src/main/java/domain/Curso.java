package domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "curso")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "fecha_inicio")
	private LocalDate fechaInicio;
	
	@Column(name = "fecha_final")
	private LocalDate fechaFinal;
	
	@OneToMany(mappedBy = "curso")
	private List<Inscripcion> inscripciones;
	
        
        public Curso(Long id, String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFinal){
            
        }
}
