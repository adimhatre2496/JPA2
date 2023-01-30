package com.example.crossasyst.Glasses.mapper;

import com.example.crossasyst.Glasses.entity.AddressEntity;
import com.example.crossasyst.Glasses.entity.PersonEntity;
import com.example.crossasyst.Glasses.model.Address;
import com.example.crossasyst.Glasses.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonEntity personToEntity(Person person);

    Person entityToPerson(PersonEntity personEntity);
}
