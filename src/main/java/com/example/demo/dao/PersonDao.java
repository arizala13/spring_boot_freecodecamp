package com.example.demo.dao;
// defines the operation allowed who wants
// to implement this interface

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    // insert person into database
    int insertPerson(UUID id, Person person);

    // allows us to generate IDs
    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    // to update a person
    int updatePersonById(UUID id, Person person);

}
