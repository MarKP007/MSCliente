/**
 * 
 */
package com.ejercicio.MSCliente.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.ejercicio.MSCliente.model.Cliente;
import com.ejercicio.MSCliente.model.ClienteDTO;
import com.ejercicio.MSCliente.repository.ClienteRepository;
import com.ejercicio.MSCliente.repository.CuentaClient;

/**
 * 
 */
@SpringJUnitConfig
@SpringBootTest(properties = { "server.port=8080", "cuentas_url=http://localhost:8081",
		"spring.jpa.properties.hibernate.format_sql=true",
		"spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.SQLServerDialect",
		"spring.jpa.hibernate.ddl-auto=update",
		"spring.datasource.url=jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;databaseName=clienteBDD",
		"spring.datasource.username=sa", "spring.datasource.password=MarKP-007", "spring.application.name=MSCliente" })
class ClienteServiceTest {

	@Autowired
	private ClienteService clienteService;

	@MockBean
	private ClienteRepository clienteRepository;

	@MockBean
	private CuentaClient cuentaClient;

	@Test
	void testFindAll() {
		List<Cliente> listaClientesDefecto = new ArrayList<>();
		Cliente cliente = new Cliente("Nombre", "Genero", 18, "1600403248", "Calle 1", "+593984807956", "1234",
				"Casado");
		listaClientesDefecto.add(cliente);
		Mockito.when(clienteRepository.findAll()).thenReturn(listaClientesDefecto);
		List<Cliente> listaClientes = clienteService.findAll();
		assertEquals(listaClientes.size(), 1);
	}

	@Test
	void testFindAllEmpty() {
		Mockito.when(clienteRepository.findAll()).thenReturn(new ArrayList<>());
		List<Cliente> listaClientes = clienteService.findAll();
		assertEquals(listaClientes, null);
	}

	@Test
	void testFindAllThrow() {
		Mockito.when(clienteRepository.findAll()).thenThrow(new UncheckedIOException(new IOException("Exception")));
		List<Cliente> listaClientes = clienteService.findAll();
		assertEquals(listaClientes, null);
	}

	@Test
	void testFindById() {
		Cliente cliente = new Cliente("Nombre", "Genero", 18, "1600403248", "Calle 1", "+593984807956", "1234",
				"Casado");
		Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
		Mockito.when(cuentaClient.getCuentasByClienteId(1L)).thenReturn(new ArrayList<>());
		Cliente clienteResponse = clienteService.findById(1L);
		assertEquals(clienteResponse, cliente);
	}

	@Test
	void testFindByIdFail() {
		Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.empty());
		Cliente clienteResponse = clienteService.findById(1L);
		assertEquals(clienteResponse, null);
	}

	@Test
	void testsaveOk() {
		Mockito.when(clienteRepository.save(new Cliente())).thenReturn(new Cliente());
		assertEquals(clienteService.save(new ClienteDTO()), new Cliente());
	}

	@Test
	void testsaveFail() {
		Mockito.when(clienteRepository.save(new Cliente()))
				.thenThrow(new UncheckedIOException(new IOException("Exception")));
		assertEquals(clienteService.save(new ClienteDTO()), null);
	}

	@Test
	void testUpdateOk() {
		Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.of(new Cliente()));
		Mockito.when(clienteRepository.save(new Cliente())).thenReturn(new Cliente());
		assertEquals(clienteService.update(1L, new ClienteDTO()), new Cliente());
	}

	@Test
	void testUpdateOkClientNotEmpty() {
		ClienteDTO clienteDTO = new ClienteDTO(1L, "nombre", "M", 38, "1234567890", "vista hermosa", "0984807956",
				"1234", "True", null);
		Cliente cliente = new Cliente("nombre", "M", 38, "1234567890", "vista hermosa", "0984807956", "1234", "True");
		Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
		Mockito.when(clienteRepository.save(cliente)).thenReturn(cliente);
		assertEquals(clienteService.update(1L, clienteDTO), cliente);
	}

	@Test
	void testUpdateEmpty() {
		Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.empty());
		Mockito.when(clienteRepository.save(new Cliente())).thenReturn(new Cliente());
		assertEquals(clienteService.update(1L, new ClienteDTO()), null);
	}

	@Test
	void testDeleteById() {
		Long numero = 1L;
		clienteService.deleteById(numero);
		assertEquals(numero, 1L);
	}
}
