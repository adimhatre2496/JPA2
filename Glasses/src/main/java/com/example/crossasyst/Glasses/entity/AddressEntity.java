package com.example.crossasyst.Glasses.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "glassAddress")
public class AddressEntity
    {

        @Id
        private Long id;

        @Column(name = "address_one")
        private String addressOne;
        @Column(name = "address_two")
        private String addressTwo;
        private String city;
        private String state;
        @Column(name = "zip_code")
        private String zipCode;

        @MapsId
        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "id")
        private PersonEntity person;

    }
