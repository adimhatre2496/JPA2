package com.example.crossasyst.Glasses.mapper;

import com.example.crossasyst.Glasses.entity.AddressEntity;
import com.example.crossasyst.Glasses.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressEntity addressToEntity(Address address);

    Address entityToAddress (AddressEntity addressEntity);
}
