package com.example.exampleliqubase.api;

import com.example.exampleliqubase.dto.EmploymentDTO;

public interface EmploymentService {
    EmploymentDTO save(EmploymentDTO employmentDTO);
    EmploymentDTO getEmploymentById(Long id);
    void updateEmployment(EmploymentDTO employmentDTO);

}
