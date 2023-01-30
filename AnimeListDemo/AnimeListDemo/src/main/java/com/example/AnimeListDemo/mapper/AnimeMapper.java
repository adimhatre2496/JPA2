package com.example.AnimeListDemo.mapper;

import com.example.AnimeListDemo.entity.AnimeEntity;
import com.example.AnimeListDemo.model.Anime;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnimeMapper {

    AnimeEntity animeToEntity (Anime anime);

    Anime entityToAnime (AnimeEntity animeEntity);
}
