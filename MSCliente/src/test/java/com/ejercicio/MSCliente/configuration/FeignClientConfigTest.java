/**
 * 
 */
package com.ejercicio.MSCliente.configuration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * 
 */
class FeignClientConfigTest {

	@Test
	void test() {
		FeignClientConfig fcg = new FeignClientConfig();
		assertNotNull(fcg.feignLoggerLevel());
	}

}
