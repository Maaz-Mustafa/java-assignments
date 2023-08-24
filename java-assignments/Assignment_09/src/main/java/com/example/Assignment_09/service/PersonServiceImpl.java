package com.example.Assignment_09.service;

import com.example.Assignment_09.dao.PersonRepository;
import com.example.Assignment_09.dto.OuterPersonDTO;
import com.example.Assignment_09.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person getPersonById(int id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            return person.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Person> getallPersons() {
        return personRepository.findAll();
    }

    @Override
    @Transactional
    public boolean savePerson(OuterPersonDTO personDTO) {
        try {
            if (personDTO.getPerson() != null) {
                personRepository.save(personDTO.getPerson());
            }
            if (personDTO.getPersonList()!=null && !personDTO.getPersonList().isEmpty()) {
                for (Person person : personDTO.getPersonList()) {
                    personRepository.save(person);
                }
            }

        } catch (Exception e) {
            return false;
        }
        return true;

    }

    @Override
    public boolean deletePerson(int id) {
        try {
            Person person = getPersonById(id);
            if(person==null){
                throw new Exception();
            }
            personRepository.delete(person);
        } catch (Exception exception) {
            return false;
        }
        return true;
    }

    @Override
    public Person updatePerson(Person person) {
        System.out.println(person.getFirstName() + " " + person.getLastName() + " " + person.getPId());
        return personRepository.save(person);
    }


}
