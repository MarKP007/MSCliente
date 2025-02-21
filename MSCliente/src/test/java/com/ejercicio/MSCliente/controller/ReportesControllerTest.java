/**
 * 
 */
package com.ejercicio.MSCliente.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.ejercicio.MSCliente.model.Cliente;
import com.ejercicio.MSCliente.model.CuentaDTO;
import com.ejercicio.MSCliente.repository.CuentaClient;
import com.ejercicio.MSCliente.service.ClienteService;

/**
 * 
 */
@SpringBootTest
@AutoConfigureMockMvc
class ReportesControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	ClienteService clienteService;

	@MockBean
	private CuentaClient cuentaClient;

	@DynamicPropertySource
	static void dynamicProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url",
				() -> "jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;databaseName=clienteBDD");
		registry.add("spring.datasource.username", () -> "sa");
		registry.add("spring.datasource.password", () -> "MarKP-007");
		registry.add("server.port", () -> "8080");
		registry.add("cuentas_url", () -> "http://localhost:8081");
	}

	@Test
	void testReporteMovimientosFail() throws Exception {
		when(clienteService.findById(1L)).thenReturn(null);
		mockMvc.perform(MockMvcRequestBuilders.get("/reportes?startDate=2024-11-26&endDate=2025-12-26&id=1")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
	}

	@Test
	void testReporteMovimientosOk() throws Exception {
		Cliente cliente = new Cliente("nombre", "M", 38, "1234567890", "vista hermosa", "0984807956", "1234", "True");
		when(clienteService.findById(1L)).thenReturn(cliente);
		List<CuentaDTO> cuentas = new ArrayList<>();
		CuentaDTO cuentaDTO = new CuentaDTO(1L, "1231231", "Deposito", 500, "activa", null);
		cuentas.add(cuentaDTO);
		when(cuentaClient.getCuentasByClienteId(1L)).thenReturn(cuentas);
		when(cuentaClient.reporteMovimientos(1L, new Date(2024, 11, 26), new Date(2025, 12, 26)))
				.thenReturn(new ArrayList<>());
		mockMvc.perform(MockMvcRequestBuilders.get("/reportes?startDate=2024-11-26&endDate=2025-12-26&id=1")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpectAll(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}

}
