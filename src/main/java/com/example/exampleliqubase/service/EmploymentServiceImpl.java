package com.example.exampleliqubase.service;

import com.example.exampleliqubase.api.EmploymentService;
import com.example.exampleliqubase.dao.EmploymentMapper;
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
public class EmploymentServiceImpl implements EmploymentService {
    @Autowired
    private EmploymentMapper employmentMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DataSource dataSource;

    @Transactional
    @Override
    public EmploymentDTO save(EmploymentDTO employmentDTO) {

        EmploymentEntity employmentEntity = modelMapper.map(employmentDTO, EmploymentEntity.class);
        //тут какая-то логика
        employmentMapper.save(employmentEntity);

        //тут еще какая-то логика

        return modelMapper.map(employmentEntity, EmploymentDTO.class);
    }

    @Transactional
    @Override
    public EmploymentDTO getEmploymentById(Long id) {
        EmploymentEntity employmentEntity = employmentMapper.getEmploymentById(id);

        return modelMapper.map(employmentEntity, EmploymentDTO.class);
    }

    @Override
    public void updateEmployment(EmploymentDTO employmentDTO) {
        EmploymentEntity employmentEntity = modelMapper.map(employmentDTO, EmploymentEntity.class);
        employmentMapper.updateEmployment(employmentEntity);
    }
}
