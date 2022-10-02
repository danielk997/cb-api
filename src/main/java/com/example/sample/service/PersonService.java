package com.example.sample.service;

import com.example.sample.dao.PersonRepository;
import com.example.sample.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository _personRepository;

    public PersonService(PersonRepository personRepository) {
        _personRepository = personRepository;
    }

    public List<Person> getAll() { return _personRepository.findAll();}
}
