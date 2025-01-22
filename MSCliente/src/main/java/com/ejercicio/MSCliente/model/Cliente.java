package com.ejercicio.MSCliente.model;

import java.util.List;

import com.ejercicio.MSCliente.utils.CampoEntidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@PrimaryKeyJoinColumn(name = CampoEntidad.PRIMARY_KEY_JOIN_COLUMN)
@Table(name = CampoEntidad.TABLE_NAME_CLIENTE)
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends Persona {

	@Column(name = CampoEntidad.CONTRASENA)
	private String contrasena;

	@Column(name = CampoEntidad.ESTADO)
	private String estado;

	@Transient
	private List<CuentaDTO> cuentas;

	public Cliente(String nombre, String genero, int edad, String identificacion, String direccion, String telefono,
			String contrasena, String estado) {
		setNombre(nombre);
		setGenero(genero);
		setEdad(edad);
		setIdentificacion(identificacion);
		setDireccion(direccion);
		setTelefono(telefono);
		this.contrasena = contrasena;
		this.estado = estado;
	}
}
