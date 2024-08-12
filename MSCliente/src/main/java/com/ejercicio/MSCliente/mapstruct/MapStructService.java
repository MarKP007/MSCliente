package com.ejercicio.MSCliente.mapstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.MSCliente.model.Cliente;
import com.ejercicio.MSCliente.model.ClienteDTO;

@Service
public class MapStructService {

	private final MapStructMapper mapStructMapper;

	@Autowired
	public MapStructService(MapStructMapper mapStructMapper) {
		this.mapStructMapper = mapStructMapper;
	}

	public ClienteDTO mapCLienteToClienteDTO(Cliente cliente) {
		return mapStructMapper.mapCLienteToClienteDTO(cliente);
	}
}
