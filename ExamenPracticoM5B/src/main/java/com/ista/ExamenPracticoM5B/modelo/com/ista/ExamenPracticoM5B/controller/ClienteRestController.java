package com.ista.ExamenPracticoM5B.modelo.com.ista.ExamenPracticoM5B.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ista.ExamenPracticoM5B.modelo.com.ista.ExamenPracticoM5B.modelo.Cliente;
import com.ista.ExamenPracticoM5B.modelo.com.ista.ExamenPracticoM5B.service.ClienteService;



@CrossOrigin(origins= {"http://localhost:8080"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	private ClienteService cliente;

	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody Cliente cli){
		return ResponseEntity.status(HttpStatus.CREATED).body(cliente.save(cli));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value ="id") Long Id){
		Optional<Cliente> user=cliente.findById(Id);
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Cliente clientes, @PathVariable(value = "id") Long userId){
		Optional<Cliente> clienteActual = cliente.findById(userId);
		
		if(!clienteActual.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		clienteActual.get().setApellido(clientes.getApellido());
		clienteActual.get().setNombre(clientes.getNombre());
		clienteActual.get().setTelefono(clientes.getTelefono());
		clienteActual.get().setFecha_nacimiento(clientes.getFecha_nacimiento());
		clienteActual.get().setSueldo(clientes.getSueldo());
		clienteActual.get().setObservacion(clientes.getObservacion());
		clienteActual.get().setSueldo(clientes.getSueldo());
		clienteActual.get().setDias_trabajo(clientes.getDias_trabajo());
		clienteActual.get().setDireccion(clientes.getDireccion());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cliente.save(clienteActual.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable (value = "id") Long userId){
		
		if (!cliente.findById(userId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		cliente.deleteById(userId);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Cliente> readAll() {
		
		List<Cliente> user = StreamSupport.stream(cliente.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return user;
	}
}
