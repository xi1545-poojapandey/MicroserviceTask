package com.microservice.aggregator;

import com.microservice.aggregator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class AggregatorApplication {



	public static void main(String[] args) {
		SpringApplication.run(AggregatorApplication.class, args);
	}

}
