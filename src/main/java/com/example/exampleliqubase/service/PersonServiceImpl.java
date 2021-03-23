package com.example.exampleliqubase.service;

import com.example.exampleliqubase.api.PersonService;
import com.example.exampleliqubase.dao.EmploymentMapper;
import com.example.exampleliqubase.dao.PersonMapper;
import com.example.exampleliqubase.dto.EmploymentDTO;
import com.example.exampleliqubase.dto.PersonDTO;
import com.example.exampleliqubase.model.EmploymentEntity;
import com.example.exampleliqubase.model.PersonEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DataSource dataSource;
    @Transactional
    @Override
    public PersonDTO save(PersonDTO  PersonDTO ) {

       PersonEntity personEntity = modelMapper.map(PersonDTO , PersonEntity.class);
        //тут какая-то логика
        personMapper.savePerson(personEntity);

        //тут еще какая-то логика

        return modelMapper.map(personEntity, PersonDTO.class);
    }

}
