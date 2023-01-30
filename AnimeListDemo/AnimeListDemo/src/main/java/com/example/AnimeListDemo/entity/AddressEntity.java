package com.example.AnimeListDemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;

    @Column(name = "address_1")
    private String address1;
    @Column(name = "address_2")
    private String address2;
    private String state;
    private String zipcode;

    @OneToOne(mappedBy = "address")
    private PersonEntity person;







}
