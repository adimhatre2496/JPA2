package com.example.AnimeListDemo.mapper;

import com.example.AnimeListDemo.entity.AnimeEntity;
import com.example.AnimeListDemo.entity.PersonEntity;
import com.example.AnimeListDemo.model.Anime;
import com.example.AnimeListDemo.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMappper {

    PersonEntity personToEntity (Person person);

    Person entityToPerson (PersonEntity personEntity);
}
