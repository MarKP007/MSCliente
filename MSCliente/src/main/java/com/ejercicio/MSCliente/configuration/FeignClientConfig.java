package com.ejercicio.MSCliente.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class FeignClientConfig.
 */
@Configuration
public class FeignClientConfig {

	/**
	 * Feign logger level.
	 *
	 * @return the logger. level
	 */
	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

}
