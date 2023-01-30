package com.example.AnimeListDemo.controller;

import com.example.AnimeListDemo.model.Anime;
import com.example.AnimeListDemo.model.AnimeResponce;
import com.example.AnimeListDemo.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnimeController
{
    @Autowired
    private AnimeService animeService;


    @GetMapping(path = "/animes/{animeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Anime> getAnime(@PathVariable Long animeId)
    {
        Anime anime = animeService.getAnime(animeId);
        return new ResponseEntity<>(anime, HttpStatus.OK);
    }


    @PostMapping(path = "/animes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AnimeResponce> createAnime(@RequestBody Anime anime)
    {
        AnimeResponce animeResponce=animeService.createAnime(anime);
        return new ResponseEntity<>(animeResponce,HttpStatus.OK);
    }


    @PutMapping(path = "/animes/{animeId}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Anime>updateAnime(@PathVariable Long animeId, @RequestBody Anime anime)
    {
        animeService.updateAnime(animeId,anime);
        return  ResponseEntity.ok(anime);

    }

    @DeleteMapping(path = "/animes/{animeId}")
    public ResponseEntity<Void> deleteAnime(@PathVariable Long animeId)
    {
        animeService.deleteAnime(animeId);
        return  ResponseEntity.ok().build();
    }

}
