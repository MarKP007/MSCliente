package com.ejercicio.MSCliente.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.MSCliente.model.Cliente;
import com.ejercicio.MSCliente.model.ClienteDTO;
import com.ejercicio.MSCliente.model.CuentaDTO;
import com.ejercicio.MSCliente.repository.ClienteRepository;
import com.ejercicio.MSCliente.repository.CuentaClient;
import com.ejercicio.MSCliente.utils.EjercicioUtil;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private CuentaClient cuentaClient;

	public List<Cliente> findAll() {
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();

			clienteRepository.findAll().forEach(clientes::add);
			if (clientes.isEmpty()) {
				return null;
			}
			return clientes;
		} catch (Exception e) {
			return null;
		}
	}

	public Cliente findById(long id) {
		Optional<Cliente> clienteData = clienteRepository.findById(id);

		if (clienteData.isPresent()) {
			List<CuentaDTO> cuentas = cuentaClient.getCuentasByClienteId(id);
			Cliente cliente = clienteData.get();
			cliente.setCuentas(cuentas);
			return cliente;
		}
		return null;
	}

	public Cliente save(ClienteDTO clienteDTO) {
		try {
			Cliente _cliente = clienteRepository.save(new Cliente(clienteDTO.getNombre(), clienteDTO.getGenero(),
					clienteDTO.getEdad(), clienteDTO.getIdentificacion(), clienteDTO.getDireccion(),
					clienteDTO.getTelefono(), clienteDTO.getContrasena(), clienteDTO.getEstado()));
			return clienteRepository.save(_cliente);
		} catch (Exception e) {
			return null;
		}
	}

	public Cliente update(long id, ClienteDTO clienteDTO) {
		Optional<Cliente> clienteData = clienteRepository.findById(id);

		if (clienteData.isPresent()) {
			Cliente _cliente = clienteData.get();
			_cliente.setGenero(
					EjercicioUtil.esCampoLleno(clienteDTO.getGenero()) ? clienteDTO.getGenero() : _cliente.getGenero());
			_cliente.setNombre(
					EjercicioUtil.esCampoLleno(clienteDTO.getNombre()) ? clienteDTO.getNombre() : _cliente.getNombre());
			_cliente.setEdad(
					EjercicioUtil.esCampoLleno(clienteDTO.getEdad()) ? clienteDTO.getEdad() : _cliente.getEdad());
			_cliente.setIdentificacion(
					EjercicioUtil.esCampoLleno(clienteDTO.getIdentificacion()) ? clienteDTO.getIdentificacion()
							: _cliente.getIdentificacion());
			_cliente.setDireccion(EjercicioUtil.esCampoLleno(clienteDTO.getDireccion()) ? clienteDTO.getDireccion()
					: _cliente.getDireccion());
			_cliente.setTelefono(EjercicioUtil.esCampoLleno(clienteDTO.getTelefono()) ? clienteDTO.getTelefono()
					: _cliente.getTelefono());
			_cliente.setContrasena(EjercicioUtil.esCampoLleno(clienteDTO.getContrasena()) ? clienteDTO.getContrasena()
					: _cliente.getContrasena());
			_cliente.setEstado(
					EjercicioUtil.esCampoLleno(clienteDTO.getEstado()) ? clienteDTO.getEstado() : _cliente.getEstado());
			return clienteRepository.save(_cliente);
		} else {
			return null;
		}
	}

	public void deleteById(long id) {
		clienteRepository.deleteById(id);
	}

}