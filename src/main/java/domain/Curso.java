package domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "curso")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "fecha_inicio")
	private LocalDate fechaInicio;
	
	@Column(name = "fecha_final")
	private LocalDate fechaFinal;
	
	@OneToMany(mappedBy = "curso")
	private List<Inscripcion> inscripciones;
	
}
