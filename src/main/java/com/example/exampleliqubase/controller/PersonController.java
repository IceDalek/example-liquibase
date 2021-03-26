package com.example.exampleliqubase.controller;

import java.util.*;

import com.example.exampleliqubase.api.PersonService;
import com.example.exampleliqubase.dto.EmploymentDTO;
import com.example.exampleliqubase.dto.PersonDTO;
import liquibase.pro.packaged.E;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;


    @PostMapping("/api/save/person")
    public PersonDTO savePerson(@RequestBody @Validated PersonDTO personDTO) {
        return personService.save(personDTO);
    }

    @GetMapping("/api/person/{id}")
    public PersonDTO getPersonById(@PathVariable Long id) {
        System.out.println(personService.getPersonById(id));
        return personService.getPersonById(id);
    }

/* not needed
    @PostMapping("/api/post/persons")
    public void putListOfPersons(@RequestBody @Validated List<PersonDTO> personDTOList) {
        HashMap<Long, PersonDTO> personDTOHashMap = new HashMap<>();
        for (PersonDTO person : personDTOList) {
            personDTOHashMap.put(person.getPersonId(), person);
        }
        for (Map.Entry<Long, PersonDTO> personEntry : personDTOHashMap.entrySet()) {
            try {
                PersonDTO personFromDatabase = personService.getPersonById(personEntry.getKey());
                if (!personFromDatabase.equals(personEntry.getValue())) {

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(personDTOList);
    }
*/

}
