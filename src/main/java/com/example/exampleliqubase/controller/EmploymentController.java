package com.example.exampleliqubase.controller;

import com.example.exampleliqubase.api.EmploymentService;
import com.example.exampleliqubase.dto.EmploymentDTO;
import com.example.exampleliqubase.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmploymentController {

    @Autowired
    EmploymentService employmentService;

    @PostMapping("/api/save/empl")
    public EmploymentDTO saveEmpl(@RequestBody @Validated EmploymentDTO employmentDTO) {

        return employmentService.save(employmentDTO);
    }

    @PostMapping("/api/post/employments")
    public void putListOfEmployments(@RequestBody @Validated List<EmploymentDTO> employmentDTOList) {
        System.out.println(employmentDTOList);
        HashMap<Long, EmploymentDTO> employmentDTOHashMap = new HashMap<>();
        for (EmploymentDTO employment : employmentDTOList) {
            employmentDTOHashMap.put(employment.getEmploymentId(), employment);
        }
        for (Map.Entry<Long, EmploymentDTO> entry : employmentDTOHashMap.entrySet()) {
            EmploymentDTO employmentFromRequest = entry.getValue();
            try {
                EmploymentDTO employmentFromDB = employmentService.getEmploymentById(entry.getKey());
                if (!employmentFromDB.equals(employmentFromRequest)) {
                    employmentService.updateEmployment(employmentFromRequest);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
               employmentService.save(employmentFromRequest);
            }
        }

    }
}
