package com.example.AnimeListDemo.repository;

import com.example.AnimeListDemo.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
