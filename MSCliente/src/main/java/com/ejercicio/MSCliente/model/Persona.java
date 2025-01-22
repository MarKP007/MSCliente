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

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = CampoEntidad.TABLE_NAME_PERSONA)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = CampoEntidad.NOMBRE)
	private String nombre;

	@Column(name = CampoEntidad.GENERO)
	private String genero;

	@Column(name = CampoEntidad.EDAD)
	private int edad;

	@Column(name = CampoEntidad.IDENTIFICACION)
	private String identificacion;

	@Column(name = CampoEntidad.DIRECCION)
	private String direccion;

	@Column(name = CampoEntidad.TELEFONO)
	private String telefono;

}