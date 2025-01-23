package com.ejercicio.MSCliente.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.MSCliente.model.Cliente;
import com.ejercicio.MSCliente.model.CuentaDTO;
import com.ejercicio.MSCliente.model.MovimientoDTO;
import com.ejercicio.MSCliente.repository.CuentaClient;
import com.ejercicio.MSCliente.service.ClienteService;

// TODO: Auto-generated Javadoc
/**
 * The Class ReportesController.
 */
@RestController
@RequestMapping()
public class ReportesController {

	/** The cliente service. */
	@Autowired
	ClienteService clienteService;

	/** The cuenta client. */
	@Autowired
	private CuentaClient cuentaClient;

	/**
	 * Reporte movimientos.
	 *
	 * @param id        the id
	 * @param startDate the start date
	 * @param endDate   the end date
	 * @return the response entity
	 */
	@GetMapping("/reportes")
	public ResponseEntity<Cliente> reporteMovimientos(@RequestParam long id,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {

		Cliente cliente = clienteService.findById(id);

		if (cliente != null) {
			List<CuentaDTO> cuentas = cuentaClient.getCuentasByClienteId(id);
			for (CuentaDTO cuentaDTO : cuentas) {
				List<MovimientoDTO> movimientos = cuentaClient.reporteMovimientos(cuentaDTO.getId(), startDate,
						endDate);
				cuentaDTO.setMovimientos(movimientos);
			}
			cliente.setCuentas(cuentas);
			return new ResponseEntity<>(cliente, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
