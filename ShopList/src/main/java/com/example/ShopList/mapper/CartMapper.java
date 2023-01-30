package com.example.ShopList.mapper;

import com.example.ShopList.entity.CartEntity;
import com.example.ShopList.model.Cart;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper
    {

        CartEntity cartToEntity (Cart cart);

        Cart entityToCart (CartEntity cartEntity);

        List<Cart> entityToCarts (List<CartEntity>cartEntities);



    }
