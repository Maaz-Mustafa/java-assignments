package com.example.Assignment_09.controller;

import com.example.Assignment_09.entity.Person;
import com.example.Assignment_09.service.PersonService;
import org.aspectj.weaver.patterns.PerObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    @GetMapping("/{id}")
    public Person getPerson(@PathVariable int id){
        return personService.getPersonById(id);
    }
    @GetMapping
    public List<Person> getAllPersons(){
        return personService.getallPersons();
    }

}
