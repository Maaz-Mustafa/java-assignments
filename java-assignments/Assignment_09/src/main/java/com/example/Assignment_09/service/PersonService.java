package com.example.Assignment_09.service;

import com.example.Assignment_09.dao.PersonRepository;
import com.example.Assignment_09.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person getPersonById(int id){
         Optional<Person> person=personRepository.findById(id);
         if(person.isPresent()){
             return person.get();
         }
         else {
             return null;
         }
    }

    public List<Person> getallPersons(){
        return personRepository.findAll();
    }
}
