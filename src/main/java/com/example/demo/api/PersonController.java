package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    // define method that will serve as get request
    // GetMapping tells it that it is a getrequest
    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    // id in getmapping allows getting id and turning it into UUID
    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        // when null is return, user is not found
        return personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Person personToUpdate) {
        personService.updatePerson(id, personToUpdate);
    }
}
