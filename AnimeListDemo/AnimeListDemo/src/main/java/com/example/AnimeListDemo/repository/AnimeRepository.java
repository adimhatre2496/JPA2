package com.example.AnimeListDemo.repository;


import com.example.AnimeListDemo.entity.AnimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<AnimeEntity ,Long> {
}
