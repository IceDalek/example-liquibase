package com.example.exampleliqubase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonEntity {
private Long person_id;
private String first_name;
private String last_name;
private String middle_name;
private Date birth_date;
private String gender;

}
