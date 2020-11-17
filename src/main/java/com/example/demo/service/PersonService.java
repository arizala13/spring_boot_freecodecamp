package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

public class PersonService {
    // get reference of PersonDao
    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    // method to insert new person
    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }
}
