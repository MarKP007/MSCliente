package com.ejercicio.MSCliente.mapstruct;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapStructConfig {

	@Bean
	public MapStructMapper mapStructMapper() {
		return Mappers.getMapper(MapStructMapper.class);
	}

}
