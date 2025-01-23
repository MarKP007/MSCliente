package com.ejercicio.MSCliente.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class MovimientoDTO.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimientoDTO {

	/** The id. */
	private long id;

	/** The fecha. */
	private Date fecha;

	/** The tipo movimiento. */
	private String tipoMovimiento;

	/** The valor. */
	private double valor;

	/** The saldo. */
	private double saldo;

	/** The cuenta id. */
	private long cuentaId;

}