package com.example.ShopList.repository;

import com.example.ShopList.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity,Long> {
    ItemEntity findByItemName(String itemName);
}
