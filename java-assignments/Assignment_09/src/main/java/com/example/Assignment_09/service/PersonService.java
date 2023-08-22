package com.example.Assignment_09.service;

import com.example.Assignment_09.dto.OuterPersonDTO;
import com.example.Assignment_09.entity.Person;

import java.util.List;


public interface PersonService {


    Person getPersonById(int id);

    List<Person> getallPersons();

    boolean savePerson(OuterPersonDTO person);

    boolean deletePerson(int id);
    Person updatePerson(Person person);
}
