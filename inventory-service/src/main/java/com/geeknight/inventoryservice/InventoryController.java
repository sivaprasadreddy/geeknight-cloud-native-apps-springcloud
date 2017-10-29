package com.geeknight.inventoryservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryController {
    private InventoryItemRepository repo;

    @Autowired
    public InventoryController(InventoryItemRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/inventory")
    @HystrixCommand
    public List<InventoryItem> getInventory() {
        return repo.findAll();
    }
}
