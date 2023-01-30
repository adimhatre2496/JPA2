package com.example.AnimeListDemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address
    {

        private String address1;
        private String address2;
        private String state;
        private String zipcode;
    }
