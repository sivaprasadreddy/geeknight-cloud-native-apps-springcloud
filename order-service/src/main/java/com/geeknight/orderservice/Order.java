package com.geeknight.orderservice;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerEmail;

    private String customerAddress;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items;

}
