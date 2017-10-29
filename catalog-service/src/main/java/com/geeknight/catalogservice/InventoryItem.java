package com.geeknight.catalogservice;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InventoryItem {
    private Long productId;
    private int quantity;
}
