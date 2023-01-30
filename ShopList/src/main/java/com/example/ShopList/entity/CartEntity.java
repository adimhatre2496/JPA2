package com.example.ShopList.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cart")
public class CartEntity
    {

        @Id
        @SequenceGenerator(name = "seq_Cart_Id", sequenceName = "seq_Cart_Id",initialValue = 100,allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_Cart_Id")
        private Long id;

        @Column(name = "firstName")
        private String firstName;

        @Column(name = "lastName")
        private String lastName;

        @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(name = "cart_id")
        private List<ItemEntity> items;




    }
