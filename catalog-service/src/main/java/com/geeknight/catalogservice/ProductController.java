package com.geeknight.catalogservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private CatalogService catalogService;

    @Autowired
    public ProductController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/api/products")
    public List<Product> allProducts() {
        return catalogService.getAvailableProducts();
    }
}
