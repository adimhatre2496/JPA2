package com.example.ShopList.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Items")
public class ItemEntity
    {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String itemName;
        private Long quantity;
        private  Long price;

        @ManyToOne
        @JoinColumn(name = "cart_id")
        private CartEntity cart;


    }
