package com.example.Assignment_09.dto;

import com.example.Assignment_09.entity.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OuterPersonDTO {
    Person person;
    List<Person> personList;

}
