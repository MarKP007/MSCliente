package com.ejercicio.MSCliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio.MSCliente.model.Cliente;

/**
 * The Interface ClienteRepository.
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
