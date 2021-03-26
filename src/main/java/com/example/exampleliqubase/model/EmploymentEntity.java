package com.example.exampleliqubase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmploymentEntity {
    private Long employmentId;
    private Integer version;
    private Date startDt;
    private Date endDt;
    private Long workTypeId;
    private String organizationName;
    private String organizationAddress;
    private String positionName;
    private Long personId;
}
