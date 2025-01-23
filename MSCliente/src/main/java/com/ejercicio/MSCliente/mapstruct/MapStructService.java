package com.ejercicio.MSCliente.mapstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.MSCliente.model.Cliente;
import com.ejercicio.MSCliente.model.ClienteDTO;

// TODO: Auto-generated Javadoc
/**
 * The Class MapStructService.
 */
@Service
public class MapStructService {

	/** The map struct mapper. */
	private final MapStructMapper mapStructMapper;

	/**
	 * Instantiates a new map struct service.
	 *
	 * @param mapStructMapper the map struct mapper
	 */
	@Autowired
	public MapStructService(MapStructMapper mapStructMapper) {
		this.mapStructMapper = mapStructMapper;
	}

	/**
	 * Map C liente to cliente DTO.
	 *
	 * @param cliente the cliente
	 * @return the cliente DTO
	 */
	public ClienteDTO mapCLienteToClienteDTO(Cliente cliente) {
		return mapStructMapper.mapCLienteToClienteDTO(cliente);
	}
}
