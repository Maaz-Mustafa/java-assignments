package com.example.Assignment_09.controller;

import com.example.Assignment_09.dto.OuterPersonDTO;
import com.example.Assignment_09.entity.Person;
import com.example.Assignment_09.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public boolean save(@RequestBody OuterPersonDTO personDTO){
        System.out.println(personDTO );


//        OuterPersonDTO personDTO=(OuterPersonDTO)person;
//        System.out.println(personDTO.getPersonList());
        return personService.savePerson(personDTO);

    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){
        return personService.deletePerson(id);
    }

    @PutMapping
    public Person update(@RequestBody Person person){
        return personService.updatePerson(person);
    }


}
