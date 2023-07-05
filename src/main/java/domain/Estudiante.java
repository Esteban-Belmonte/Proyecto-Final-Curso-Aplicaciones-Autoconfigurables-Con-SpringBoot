package domain;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.Formula;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estudiante")
@Data
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;
	
	@Formula("YEAR(CURRENT_DATE) - YEAR(fecha_nacimiento)")
	@Transient
	private int edad;
	
	@OneToMany(mappedBy = "estudiante")
	private List<Inscripcion> inscripciones;
	
	
}
