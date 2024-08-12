package com.ejercicio.MSCliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.MSCliente.mapstruct.MapStructService;
import com.ejercicio.MSCliente.model.Cliente;
import com.ejercicio.MSCliente.model.ClienteDTO;
import com.ejercicio.MSCliente.repository.CuentaClient;
import com.ejercicio.MSCliente.service.ClienteService;
import com.ejercicio.MSCliente.utils.EjercicioUtil;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@Autowired
	MapStructService mapStructService;

	@Autowired
	private CuentaClient cuentaClient;

	@GetMapping
	public ResponseEntity<List<ClienteDTO>> obtenerTodosClientes() {
		List<Cliente> clientes = clienteService.findAll();
		if (clientes != null) {
			List<ClienteDTO> listaClienteDTO = EjercicioUtil.convertList(clientes,
					c -> mapStructService.mapCLienteToClienteDTO(c));
			return new ResponseEntity<>(listaClienteDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> obtenerClientePorId(@PathVariable("id") long id) {
		Cliente clienteData = clienteService.findById(id);

		if (clienteData != null) {
			return new ResponseEntity<>(mapStructService.mapCLienteToClienteDTO(clienteData), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<ClienteDTO> crearCliente(@RequestBody ClienteDTO cliente) {
		Cliente _cliente = clienteService.save(cliente);
		if (cliente != null) {
			return new ResponseEntity<>(mapStructService.mapCLienteToClienteDTO(_cliente), HttpStatus.CREATED);
		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> updateCliente(@PathVariable("id") long id, @RequestBody ClienteDTO clienteDTO) {
		Cliente cliente = clienteService.update(id, clienteDTO);
		if (cliente != null) {
			return new ResponseEntity<>(mapStructService.mapCLienteToClienteDTO(cliente), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> eliminarCliente(@PathVariable("id") long id) {
		try {
			cuentaClient.deleteByClientId(id);
			clienteService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}