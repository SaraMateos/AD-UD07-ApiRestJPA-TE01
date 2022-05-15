package eus.birt.dam.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="cita")
public class Cita {
	
	private static final long serialVersionUID = 1L;

	//Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="paciente")
	private String paciente;
	
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	
	@Column(name="informe")
	private String informe;
		
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="medico_id")
	private Medico medico;

	//Cosntructores
	public Cita() {
		super();
	}
	
	public Cita(String paciente, LocalDate fecha, String informe) {
		super();
		this.paciente = paciente;
		this.fecha = fecha;
		this.informe = informe;
	}

	//Getters y Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getInforme() {
		return informe;
	}

	public void setInforme(String informe) {
		this.informe = informe;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	
}
