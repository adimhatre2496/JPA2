package com.example.crossasyst.Glasses.repository;

import com.example.crossasyst.Glasses.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity,Long>
    {

    }
