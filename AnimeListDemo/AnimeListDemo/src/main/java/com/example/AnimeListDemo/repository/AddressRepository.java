package com.example.AnimeListDemo.repository;

import com.example.AnimeListDemo.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository  extends JpaRepository<AddressEntity, Long> {
}
