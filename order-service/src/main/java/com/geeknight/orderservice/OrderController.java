package com.geeknight.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private OrderRepository repo;

    @Autowired
    public OrderController(OrderRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        return repo.save(order);
    }

    @GetMapping("/orders/{id}")
    public Order findOrderById(@PathVariable Long id) {
        return repo.findOne(id);
    }

}
