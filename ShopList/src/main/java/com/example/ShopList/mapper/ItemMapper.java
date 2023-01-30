package com.example.ShopList.mapper;

import com.example.ShopList.entity.ItemEntity;
import com.example.ShopList.model.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemEntity itemToEntity (Item item);

    Item  entityToItem(ItemEntity itemEntity);
}
