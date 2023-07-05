package domain;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "inscripcion")
public class Inscripcion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fecha_inscripcion")
	private LocalDate fechaInscripcion;
	
	@Column(name = "estado_inscripcion")
	private EstadoInscripcion estado;
	
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name = "estudiante_id")
	private Estudiante estudiante;
}
