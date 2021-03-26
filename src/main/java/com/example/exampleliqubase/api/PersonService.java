package com.example.exampleliqubase.api;

import com.example.exampleliqubase.dto.PersonDTO;

public interface PersonService {
    PersonDTO save(PersonDTO personDTO);
    PersonDTO getPersonById(Long id);
}
