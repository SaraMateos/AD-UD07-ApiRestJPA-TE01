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

import eus.birt.dam.domain.Medico;
import eus.birt.dam.repository.MedicoRepository;

@RestController
@RequestMapping ("api/medicos")
public class MedicoController {

	@Autowired
	MedicoRepository medicoRepository;
		
	//Muestra todos los médicos
	@GetMapping({"/",""})
	public List <Medico> index() {
		return medicoRepository.findAll();
	}
	
	//Muestra el médico con dicho ID
	@GetMapping("/{id}")
	public Medico show(@PathVariable("id") Long id) {
		return medicoRepository.findById(id).orElse(null);
	}
	
	//Crear un nuevo médico
	@PostMapping("/")
	@ResponseStatus (HttpStatus.CREATED)
	public Medico create(@RequestBody Medico medico) {
		return medicoRepository.save(medico);
	}
	
	//Actualiza el médico con el id seleccionado
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Medico update(@RequestBody Medico medico, @PathVariable("id") Long id) {
		Medico tempmedico = medicoRepository.findById(id).orElse(null);
		
		tempmedico.setNombre(medico.getNombre());
		tempmedico.setApellidos(medico.getApellidos());
		tempmedico.setNacimiento(medico.getNacimiento());
		tempmedico.setEspecialidad(medico.getEspecialidad());
		
		return medicoRepository.save(tempmedico);
	}
	
	//Borrar el médico con el id seleccionado
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		medicoRepository.deleteById(id);
	}
	
}
