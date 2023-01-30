package com.example.crossasyst.Glasses.repository;

import com.example.crossasyst.Glasses.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Long>
    {

    }
