package com.ejercicio.MSCliente.repository;

import java.util.Date;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.ejercicio.MSCliente.configuration.FeignClientConfig;
import com.ejercicio.MSCliente.model.CuentaDTO;
import com.ejercicio.MSCliente.model.MovimientoDTO;

@FeignClient(name = "Cuentas", url = "${cuentas_url}", configuration = FeignClientConfig.class)
public interface CuentaClient {

	@GetMapping("/cuentas/cliente/{clienteId}")
	List<CuentaDTO> getCuentasByClienteId(@PathVariable("clienteId") long clienteId);

	@DeleteMapping("/cuentas/cliente/{clientId}")
	void deleteByClientId(@PathVariable("clientId") long clientId);

	@GetMapping("/movimientos/movimientos")
	List<MovimientoDTO> reporteMovimientos(@RequestParam long id,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate);
}
