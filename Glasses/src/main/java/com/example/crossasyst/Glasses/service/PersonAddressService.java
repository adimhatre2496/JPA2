package com.example.crossasyst.Glasses.service;

import com.example.crossasyst.Glasses.entity.AddressEntity;
import com.example.crossasyst.Glasses.entity.PersonEntity;
import com.example.crossasyst.Glasses.mapper.AddressMapper;
import com.example.crossasyst.Glasses.mapper.PersonMapper;
import com.example.crossasyst.Glasses.model.Address;
import com.example.crossasyst.Glasses.model.Person;
import com.example.crossasyst.Glasses.model.PersonResponse;
import com.example.crossasyst.Glasses.repository.AddressRepository;
import com.example.crossasyst.Glasses.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class PersonAddressService
    {
        @Autowired
        private PersonRepository repository;
        @Autowired
        private AddressRepository addressRepository;
        @Autowired
        private PersonMapper personMapper;
        @Autowired
        private AddressMapper addressMapper;

        public PersonResponse createPerson(Person person)
        {
            PersonEntity personEntity= null;

            personEntity= personMapper.personToEntity(person);
            personEntity.getAddress().setPerson(personEntity);

            repository.save(personEntity);

            PersonResponse personResponse = new PersonResponse();
            personResponse.setPersonId(personEntity.getId());

            log.info("Posting.....");

            return personResponse;
        }

        public Person getById(Long id)
        {
            Person person=new Person();
            Optional<PersonEntity>personEntityOptional=repository.findById(id);
            if(personEntityOptional.isPresent())
            {
                person=personMapper.entityToPerson(personEntityOptional.get());
                log.info("Fetching.......");
            }
            else
            {
                log.info("Id Not Found"+id);
            }
            return person;
        }

        public void deleteById(Long id)
        {
            Optional<PersonEntity>personEntityOptional=repository.findById(id);
            if(personEntityOptional.isPresent())
            {
                repository.deleteById(id);
                log.info("Deleting.......");
            }
            else
            {
                log.info("Id Not Found");
            }
        }

        public Person updatePerson(Long personId, Person person)
        {
            PersonEntity personEntity = repository.findById(personId).get();
            AddressEntity addressEntity = addressRepository.findById(personEntity.getAddress().getId()).get();

            addressEntity.setAddressOne(person.getAddress().getAddressOne());
            addressEntity.setAddressTwo(person.getAddress().getAddressTwo());
            addressEntity.setCity(person.getAddress().getCity());
            addressEntity.setState(person.getAddress().getState());
            addressRepository.save(addressEntity);

            personEntity.setFirstName(person.getFirstName());
            personEntity.setLastName(person.getLastName());
            personEntity.setAddress(addressEntity);
            repository.save(personEntity);

            return person;
        }

    }
