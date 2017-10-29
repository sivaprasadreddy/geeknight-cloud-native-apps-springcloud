package com.geeknight.catalogservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CatalogService {
    private ProductRepository repo;
    private RestTemplate restTemplate;

    @Autowired
    public CatalogService(ProductRepository repo, RestTemplate restTemplate) {
        this.repo = repo;
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getDefaultAvailableProducts")
    public List<Product> getAvailableProducts() {
        List<Product> products = repo.findAll();
        final Map<Long, Integer> inventoryLevels = getInventoryLevels();
        final List<Product> availableProducts = products.stream()
                .filter(p -> inventoryLevels.get(p.getId()) != null && inventoryLevels.get(p.getId()) > 0)
                .collect(Collectors.toList());
        return availableProducts;
    }

    public List<Product> getDefaultAvailableProducts() {
        log.info("Returning default available products");
        return new ArrayList<>();
    }

    public Map<Long, Integer> getInventoryLevels() {
        Map<Long, Integer> inventoryLevels = new HashMap<>();
        final ResponseEntity<InventoryItem[]> responseEntity = restTemplate.getForEntity("http://inventory-service/api/inventory", InventoryItem[].class);
        for (InventoryItem item: responseEntity.getBody()){
            inventoryLevels.put(item.getProductId(), item.getQuantity());
        }
        log.debug("InventoryLevels: {}", inventoryLevels);
        return inventoryLevels;
    }
}
