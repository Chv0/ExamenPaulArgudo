package com.ista.ExamenPracticoM5B.modelo.com.ista.ExamenPracticoM5B.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ista.ExamenPracticoM5B.modelo.com.ista.ExamenPracticoM5B.modelo.Cliente;
import com.ista.ExamenPracticoM5B.modelo.com.ista.ExamenPracticoM5B.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService{
	private ClienteRepository users;

	@Override
	@Transactional
	public Iterable<Cliente> findAll() {
		return users.findAll();
	}

	@Override
	@Transactional
	public Page<Cliente> findAll(Pageable pageable) {
		return users.findAll(pageable);
	}

	@Override
	@Transactional
	public Optional<Cliente> findById(Long Id) {
		return users.findById(Id);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return users.save(cliente);
	}

	@Override
	@Transactional
	public void deleteById(Long Id) {
		users.deleteById(Id);
	}

}
