package com.ejercicio.MSCliente.model;

import java.util.List;

import com.ejercicio.MSCliente.utils.CampoEntidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class Cliente.
 */
@Entity
@PrimaryKeyJoinColumn(name = CampoEntidad.PRIMARY_KEY_JOIN_COLUMN)
@Table(name = CampoEntidad.TABLE_NAME_CLIENTE)
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends Persona {

	/** The contrasena. */
	@NotBlank(message = "El campo contraseña es obligaorio.")
	@Column(name = CampoEntidad.CONTRASENA)
	private String contrasena;

	/** The estado. */
	@Column(name = CampoEntidad.ESTADO)
	private String estado;

	/** The cuentas. */
	@Transient
	private List<CuentaDTO> cuentas;

	/**
	 * Instantiates a new cliente.
	 *
	 * @param nombre         the nombre
	 * @param genero         the genero
	 * @param edad           the edad
	 * @param identificacion the identificacion
	 * @param direccion      the direccion
	 * @param telefono       the telefono
	 * @param contrasena     the contrasena
	 * @param estado         the estado
	 */
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
