package domain;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inscripcion")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inscripcion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fecha_inscripcion")
	private LocalDate fechaInscripcion;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "estado_inscripcion")
	private EstadoInscripcion estado;
	
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name = "estudiante_id")
	private Estudiante estudiante;
        
}
