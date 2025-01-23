package com.ejercicio.MSCliente.mapstruct;

import org.mapstruct.Mapper;

import com.ejercicio.MSCliente.model.Cliente;
import com.ejercicio.MSCliente.model.ClienteDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface MapStructMapper.
 */
@Mapper(componentModel = "spring")
public interface MapStructMapper {

	/**
	 * Map C liente to cliente DTO.
	 *
	 * @param cliente the cliente
	 * @return the cliente DTO
	 */
	ClienteDTO mapCLienteToClienteDTO(Cliente cliente);
}
