package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Adding Repository makes it obvious that this class
// is served as a Repository

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{
    // define list
    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        // allows person insertion
        DB.add(new Person(id, person.getName()));
        return 1;
    }
}
