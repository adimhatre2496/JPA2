package com.example.crossasyst.Glasses.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "glassPerson")
public class PersonEntity
    {
        @Id
        @SequenceGenerator(name = "seq_glassperson_Id",initialValue = 100,sequenceName ="seq_glassperson_Id",allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_glassperson_Id")
        private Long id;

        @Column(name = "first_Name")
        private String firstName;

        @Column(name = "last_Name")
        private String lastName;

        @OneToOne (mappedBy = "person", cascade = CascadeType.ALL)
        @PrimaryKeyJoinColumn(name = "id")
        private AddressEntity address;

    }
