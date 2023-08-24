package com.example.Assignment_09.service;

import com.example.Assignment_09.dao.PersonRepository;
import com.example.Assignment_09.dto.OuterPersonDTO;
import com.example.Assignment_09.entity.Person;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PersonServiceImplTest {

    @Mock
    private PersonRepository personRepository;
    @InjectMocks
    private PersonServiceImpl personService;
    Person person;
    OuterPersonDTO outerPersonDTO;

    List<Person> personList;

    @BeforeEach
    void setUp() {
        person = new Person(1, "a", "b");
        outerPersonDTO = new OuterPersonDTO();
        outerPersonDTO.setPerson(person);

        personList=new ArrayList<>(){
            {
                add(new Person(2,"test1","testing1"));
                add(new Person(3,"test2","testing2"));
            }
        };
        outerPersonDTO.setPersonList(personList);

//        Mockito.when(personRepository.save(person)).thenReturn(person);

    }

    @Test
    void getPersonById() {
        Optional<Person> op = Optional.of(person);
        Mockito.when(personRepository.findById(1)).thenReturn(op);
        Person returenedPerson=personService.getPersonById(1);
        Assertions.assertThat(returenedPerson.getFirstName()).isEqualTo("a");
    }
    @Test
    void getPersonByIdWithoutMatchingId() {
        Optional<Person> op = Optional.of(person);
        Mockito.when(personRepository.findById(1)).thenReturn(op);
        Person returenedPerson=personService.getPersonById(10);
        Assertions.assertThat(returenedPerson).isNull();
    }

    @Test
    void getallPersons() {
        Mockito.when(personRepository.findAll()).thenReturn(personList);

        List<Person> testingList=personService.getallPersons();
        Assert.assertEquals(2,personService.getallPersons().size());
        Assertions.assertThat(testingList.get(0).getFirstName()).isEqualTo("test1");
        Assertions.assertThat(testingList.get(0).getLastName()).isEqualTo("testing1");
    }

    @Test
    void savePerson() {
            Mockito.when(personRepository.save(person)).thenReturn(person);

            boolean testPerson=personService.savePerson(outerPersonDTO);

            Assertions.assertThat(testPerson).isEqualTo(true);

    }

    @Test
    void savePersonForListOfPersons() {

        for (Person person : outerPersonDTO.getPersonList()) {
            personRepository.save(person);
        }
        Assertions.assertThat(outerPersonDTO.getPersonList().get(0).getFirstName()).isEqualTo("test1");
        Assertions.assertThat(outerPersonDTO.getPersonList().get(0).getLastName()).isEqualTo("testing1");

    }

    @Test
    void deletePerson() {

        Optional<Person> op = Optional.of(person);
        Mockito.when(personRepository.findById(1)).thenReturn(op);
        boolean result = personService.deletePerson(person.getPId());
        Assert.assertEquals(true,result);
        Mockito.verify(personRepository,Mockito.times(1)).delete(person);

    }

    @Test
    void updatePerson() {
        Mockito.when(personRepository.save(person)).thenReturn(person);
        Person testPerson=personService.updatePerson(person);
        Assertions.assertThat(testPerson.getFirstName()).isEqualTo("a");
        Assertions.assertThat(testPerson.getLastName()).isEqualTo("b");

    }

    @Test
    void deleteFailure(){
        Optional<Person> op = Optional.of(person);
        Mockito.when(personRepository.findById(1)).thenReturn(op);
//        Mockito.when(personRepository.delete())
        boolean result= personService.deletePerson(2);
        Assert.assertEquals(false,result);


    }
}