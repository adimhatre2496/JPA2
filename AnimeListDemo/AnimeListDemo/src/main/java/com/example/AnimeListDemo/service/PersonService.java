package com.example.AnimeListDemo.service;

import com.example.AnimeListDemo.entity.AddressEntity;
import com.example.AnimeListDemo.entity.PersonEntity;
import com.example.AnimeListDemo.mapper.PersonMappper;
import com.example.AnimeListDemo.model.Person;
import com.example.AnimeListDemo.model.PersonResponce;
import com.example.AnimeListDemo.repository.AddressRepository;
import com.example.AnimeListDemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMappper personMappper;

    @Autowired
    private AddressRepository addressRepository;

    /*public PersonResponce createPerson(Person person)
    {
        PersonEntity personEntity =null;

        personEntity=personMappper.personToEntity(person);
        AddressEntity address = personMappper.
        PersonResponce personResponce =new PersonResponce();
        Long id = (long)(Math.random()*20);
        personEntity.setId(id);
        personResponce.setId(personEntity.getId());
        personRepository.save(personEntity);
       return personResponce;


    }*/

    /*public PersonResponce createPerson(Person person) {


        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddress1(person.getAddress().getAddress1());
        addressEntity.setAddress2(person.getAddress().getAddress2());

        addressEntity.setState(person.getAddress().getState());
        addressEntity.setZipcode(person.getAddress().getZipcode());
        addressRepository.save(addressEntity);
        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());
        personEntity.setAddress(addressEntity);
        personRepository.save(personEntity);
        PersonResponce personResponse = new PersonResponce();
        personResponse.setId(personEntity.getId());
        return personResponse;
    }*/

    public PersonResponce createPerson(Person person) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddress1(person.getAddress().getAddress1());
        addressEntity.setAddress2(person.getAddress().getAddress2());

        addressEntity.setState(person.getAddress().getState());
        addressEntity.setZipcode(person.getAddress().getZipcode());
        addressRepository.save(addressEntity);
        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());
        personEntity.setAddress(addressEntity);
        personRepository.save(personEntity);
        PersonResponce personResponse = new PersonResponce();
        personResponse.setId(personEntity.getId());
        return personResponse;


    }
}
