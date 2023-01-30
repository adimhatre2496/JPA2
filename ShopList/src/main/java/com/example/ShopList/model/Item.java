package com.example.ShopList.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item
    {
        private String itemName;

        private Long quantity, price;
    }
