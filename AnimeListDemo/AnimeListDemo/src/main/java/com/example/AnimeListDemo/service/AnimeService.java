package com.example.AnimeListDemo.service;

import com.example.AnimeListDemo.entity.AnimeEntity;
import com.example.AnimeListDemo.mapper.AnimeMapper;
import com.example.AnimeListDemo.model.Anime;
import com.example.AnimeListDemo.model.AnimeResponce;
import com.example.AnimeListDemo.repository.AnimeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class AnimeService
    {
        @Autowired
        private AnimeRepository animeRepository;
        @Autowired
        private AnimeMapper animeMapper;

        public Anime getAnime(Long animeId)
        {
            Anime anime = new Anime();
            Optional<AnimeEntity> animeEntity = animeRepository.findById(animeId);
            if (animeEntity.isPresent())
            {
                anime = animeMapper.entityToAnime(animeEntity.get());
                log.info("Anime Found With Id " + animeId);
            }
            else
            {
                log.info(+animeId + "Anime Id Not Found");
            }

            return anime;
        }

        public AnimeResponce createAnime(Anime anime)
        {
            AnimeResponce animeResponce=new AnimeResponce();
            AnimeEntity animeEntity = animeMapper.animeToEntity(anime);

            Long id= (long) (Math.random()*20);
            animeEntity.setId(id);
            animeResponce.setId(animeEntity.getId());

            animeRepository.save(animeEntity);

            log.info("New Anime Is Added to the List with Anime ID "+id);
            return animeResponce;
        }

        public Anime updateAnime(Long animeId, Anime anime) {

            Optional<AnimeEntity> animeEntity = animeRepository.findById(animeId);

            if (animeEntity.isPresent()) {

                   animeEntity.get().setAnimeName(anime.getAnimeName());
                  animeEntity.get().setMainLeadName(anime.getMainLeadName());

                  animeRepository.save(animeEntity.get());
            }
            else
            {
                log.info("Book With Id not found");
            }
            return anime;
        }


        public void deleteAnime(Long animeId)
        {
           Optional<AnimeEntity> animeEntity = animeRepository.findById(animeId);

            if(animeEntity.isPresent()){

                animeRepository.deleteById(animeId);
                log.info("Delete Successfull " +animeId);
            }

            else {
                log.info("Id not Found");
            }

        }


    }
