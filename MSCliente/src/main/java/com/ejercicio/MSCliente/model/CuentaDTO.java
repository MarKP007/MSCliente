package com.ejercicio.MSCliente.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class CuentaDTO.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuentaDTO {

	/** The id. */
	private long id;

	/** The numero cuenta. */
	private String numeroCuenta;

	/** The tipo cuenta. */
	private String tipoCuenta;

	/** The saldo inicial. */
	private double saldoInicial;

	/** The estado. */
	private String estado;

	/** The movimientos. */
	private List<MovimientoDTO> movimientos;

}