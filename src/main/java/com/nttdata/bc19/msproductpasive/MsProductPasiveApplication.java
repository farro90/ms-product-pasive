package com.nttdata.bc19.msproductpasive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsProductPasiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProductPasiveApplication.class, args);
	}

}
