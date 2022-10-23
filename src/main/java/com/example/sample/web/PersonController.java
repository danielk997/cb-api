package com.example.sample.web;

import com.example.sample.model.Person;
import com.example.sample.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    private final PersonService _personService;

    public PersonController(PersonService personService) {
        _personService = personService;
    }

    @GetMapping
    ResponseEntity<List<Person>> getAll(Principal principal) {
        if(principal == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<Person> persons = _personService.getAll();

        return ResponseEntity.status(HttpStatus.OK).body(persons);
    }
}
