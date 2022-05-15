package eus.birt.dam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import eus.birt.dam.domain.Cita;
import eus.birt.dam.repository.CitaRepository;
import eus.birt.dam.repository.MedicoRepository;

@RestController
@RequestMapping("api/citas")
public class CitaController {

	@Autowired
	CitaRepository citaRepository;
	
	@Autowired
	MedicoRepository medicoRepository;
	
	//Muestra todas las citas
	@GetMapping({"/",""})
	public List <Cita> index() {
		return citaRepository.findAll();
	}
	
	//Muestra la cita con dicho ID
	@GetMapping("/{id}")
	public Cita show(@PathVariable("id") Long id) {
		return citaRepository.findById(id).orElse(null);
	}
	
	//Crear una nueva cita
	@PostMapping("/")
	@ResponseStatus (HttpStatus.CREATED)
	public Cita create(@RequestBody Cita cita) {
		return citaRepository.save(cita);
	}
	
	//Actualiza la cita del id seleccionado
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Cita update(@RequestBody Cita cita, @PathVariable("id") Long id) {
		Cita tempCita = citaRepository.findById(id).orElse(null);
		
		tempCita.setPaciente(cita.getPaciente());
		tempCita.setFecha(cita.getFecha());
		tempCita.setInforme(cita.getInforme());
		tempCita.setMedico(cita.getMedico());
		
		return citaRepository.save(tempCita);
	}
	
	//Borrar la cita del id seleccionado
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		citaRepository.deleteById(id);
	}
}
