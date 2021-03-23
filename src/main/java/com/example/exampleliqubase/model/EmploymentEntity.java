package com.example.exampleliqubase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmploymentEntity {
    private Long employment_id;
    private Integer version;
    private Date start_dt;
    private Date end_dt;
    private Long work_type_id;
    private String organization_name;
    private String organization_address;
    private String position_name;
    private Long person_id;
}
