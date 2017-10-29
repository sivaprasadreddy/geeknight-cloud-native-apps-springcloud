package com.geeknight.inventoryservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Component;

@EnableHystrix
@EnableEurekaClient
@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
}

@Component
class DatabaseInitializer implements CommandLineRunner{

	@Autowired
	private InventoryItemRepository repo;

	@Override
	public void run(String... strings) throws Exception {
		repo.save(new InventoryItem(null, 1L, 500));
		repo.save(new InventoryItem(null, 2L, 100));
		repo.save(new InventoryItem(null, 3L, 250));
		repo.save(new InventoryItem(null, 4L, 50));
	}
}
