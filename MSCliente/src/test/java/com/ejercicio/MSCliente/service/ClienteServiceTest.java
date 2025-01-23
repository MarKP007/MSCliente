/**
 * 
 */
package com.ejercicio.MSCliente.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.ejercicio.MSCliente.model.Cliente;
import com.ejercicio.MSCliente.repository.ClienteRepository;

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

	@BeforeEach
	void setUp() {
		List<Cliente> listaClientesDefecto = new ArrayList<>();
		Cliente cliente = new Cliente("Nombre", "Genero", 18, "1600403248", "Calle 1", "+593984807956", "1234",
				"Casado");
		listaClientesDefecto.add(cliente);
		Mockito.when(clienteRepository.findAll()).thenReturn(listaClientesDefecto);
	}

	@Test
	void testFindAll() {
		List<Cliente> listaClientes = clienteService.findAll();
		assertEquals(listaClientes.size(), 1);
	}

}
