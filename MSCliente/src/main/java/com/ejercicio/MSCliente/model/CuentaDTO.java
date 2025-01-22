package com.ejercicio.MSCliente.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuentaDTO {

	private long id;
	private String numeroCuenta;
	private String tipoCuenta;
	private double saldoInicial;
	private String estado;
	private List<MovimientoDTO> movimientos;

}