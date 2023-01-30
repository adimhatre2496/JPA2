package com.example.ShopList.service;

import com.example.ShopList.entity.ItemEntity;
import com.example.ShopList.repository.CartRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class Cart2Service
    {
        @Autowired
        private CartRepository cartRepository;

       /* public void deleteByName(String name) {
            List<ItemEntity> itemEntities= cartRepository.deleteAllInBatch(name);
        }*/
    }
