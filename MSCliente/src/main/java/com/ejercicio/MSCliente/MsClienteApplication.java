package com.ejercicio.MSCliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

// TODO: Auto-generated Javadoc
/**
 * The Class MsClienteApplication.
 */
@SpringBootApplication
@EnableFeignClients
public class MsClienteApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(MsClienteApplication.class, args);
	}

}
