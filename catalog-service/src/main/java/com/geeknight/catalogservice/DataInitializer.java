package com.geeknight.catalogservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner{
    @Autowired
    private ProductRepository repo;

    @Override
    public void run(String... strings) throws Exception {
        repo.save(new Product(1L, "Product 1", "Product 1 description", new BigDecimal(20)));
        repo.save(new Product(2L, "Product 2", "Product 2 description", new BigDecimal(40)));
        repo.save(new Product(3L, "Product 3", "Product 3 description", new BigDecimal(10)));
        repo.save(new Product(4L, "Product 4", "Product 4 description", new BigDecimal(70)));
        repo.save(new Product(5L, "Product 5", "Product 5 description", new BigDecimal(120)));
    }
}
