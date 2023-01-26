package com.ista.ExamenPracticoM5B.modelo.com.ista.ExamenPracticoM5B.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ista.ExamenPracticoM5B.modelo.com.ista.ExamenPracticoM5B.modelo.Cliente;



@Repository
public interface ClienteRepository extends  JpaRepository<Cliente, Long>{
}
