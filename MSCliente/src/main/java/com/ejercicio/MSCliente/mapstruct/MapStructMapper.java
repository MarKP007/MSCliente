package com.ejercicio.MSCliente.mapstruct;

import org.mapstruct.Mapper;

import com.ejercicio.MSCliente.model.Cliente;
import com.ejercicio.MSCliente.model.ClienteDTO;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

	ClienteDTO mapCLienteToClienteDTO(Cliente cliente);
}
