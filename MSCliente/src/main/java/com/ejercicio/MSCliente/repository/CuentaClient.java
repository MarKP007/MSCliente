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
import com.ejercicio.MSCliente.utils.CampoEntidad;

// TODO: Auto-generated Javadoc
/**
 * The Interface CuentaClient.
 */
@FeignClient(name = "Cuentas", url = "${cuentas_url}", configuration = FeignClientConfig.class)
public interface CuentaClient {

	/**
	 * Gets the cuentas by cliente id.
	 *
	 * @param clienteId the cliente id
	 * @return the cuentas by cliente id
	 */
	@GetMapping("/cuentas/cliente/{clienteId}")
	List<CuentaDTO> getCuentasByClienteId(@PathVariable(CampoEntidad.CLIENTE_ID) long clienteId);

	/**
	 * Delete by client id.
	 *
	 * @param clientId the client id
	 */
	@DeleteMapping("/cuentas/cliente/{clientId}")
	void deleteByClientId(@PathVariable("clientId") long clientId);

	/**
	 * Reporte movimientos.
	 *
	 * @param id        the id
	 * @param startDate the start date
	 * @param endDate   the end date
	 * @return the list
	 */
	@GetMapping("/movimientos/movimientos")
	List<MovimientoDTO> reporteMovimientos(@RequestParam long id,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate);
}
