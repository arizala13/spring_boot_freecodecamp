package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/person")

// RestController tells it it can do get, put, post methods

@RestController
public class PersonController {
    private final PersonService personService;

    // reference to service
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // method that adds a person
    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }
}
