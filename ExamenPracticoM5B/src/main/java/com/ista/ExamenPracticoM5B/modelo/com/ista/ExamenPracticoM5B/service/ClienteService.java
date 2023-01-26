package com.ista.ExamenPracticoM5B.modelo.com.ista.ExamenPracticoM5B.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

import com.ista.ExamenPracticoM5B.modelo.com.ista.ExamenPracticoM5B.modelo.Cliente;

public interface ClienteService{
	public Iterable<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable pageable);
	
	public Optional<Cliente> findById(Long userId);
	
	public Cliente save(Cliente cliente);
	
	public void deleteById(Long Id);
}
