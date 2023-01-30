package com.example.crossasyst.Glasses.controller;

import com.example.crossasyst.Glasses.model.Person;
import com.example.crossasyst.Glasses.model.PersonResponse;
import com.example.crossasyst.Glasses.service.PersonAddressService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
public class PersonController
    {
        @Autowired
        private PersonAddressService personAddressService;

        @PostMapping(path = "/persons",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)

        public ResponseEntity<PersonResponse> createPerson(@RequestBody Person person)
        {
            PersonResponse personResponse =personAddressService.createPerson(person);
            log.info("Post Successfully");
            return new ResponseEntity<>(personResponse, HttpStatus.OK);
        }

        @Cacheable(cacheNames = "persons")
        @GetMapping(path = "/persons/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
        @CachePut(cacheNames = "persons")

        public ResponseEntity<Person> getById(@PathVariable Long id)
        {
            Person person= personAddressService.getById(id);
            log.info("Get Successfully");
            return new ResponseEntity<>(person,HttpStatus.OK);
        }

        @DeleteMapping(path = "/persons/{id}")

        public ResponseEntity<Void> deleteById (@PathVariable Long id)
        {
            personAddressService.deleteById(id);
            return ResponseEntity.ok().build();
        }

        @PutMapping( path= "/address/{personId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )

        public ResponseEntity<Person> updatePerson( @PathVariable Long personId, @RequestBody Person person )
        {
           person = personAddressService.updatePerson( personId, person );
            return new ResponseEntity<>( person, HttpStatus.OK );
        }

    }
