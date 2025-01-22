package com.ejercicio.MSCliente.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimientoDTO {

	private long id;
	private Date fecha;
	private String tipoMovimiento;
	private double valor;
	private double saldo;
	private long cuentaId;

}