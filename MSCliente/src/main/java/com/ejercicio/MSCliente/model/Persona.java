package com.ejercicio.MSCliente.model;

import com.ejercicio.MSCliente.utils.CampoEntidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class Persona.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = CampoEntidad.TABLE_NAME_PERSONA)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/** The nombre. */
	@Column(name = CampoEntidad.NOMBRE)
	private String nombre;

	/** The genero. */
	@Column(name = CampoEntidad.GENERO)
	private String genero;

	/** The edad. */
	@Column(name = CampoEntidad.EDAD)
	private int edad;

	/** The identificacion. */
	@Column(name = CampoEntidad.IDENTIFICACION)
	private String identificacion;

	/** The direccion. */
	@Column(name = CampoEntidad.DIRECCION)
	private String direccion;

	/** The telefono. */
	@Column(name = CampoEntidad.TELEFONO)
	private String telefono;

}