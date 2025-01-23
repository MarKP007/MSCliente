package com.ejercicio.MSCliente.mapstruct;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// TODO: Auto-generated Javadoc
/**
 * The Class MapStructConfig.
 */
@Configuration
public class MapStructConfig {

	/**
	 * Map struct mapper.
	 *
	 * @return the map struct mapper
	 */
	@Bean
	public MapStructMapper mapStructMapper() {
		return Mappers.getMapper(MapStructMapper.class);
	}

}
