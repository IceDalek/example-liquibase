package com.example.exampleliqubase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonDTO {
    private Long personId;
    private String firstName;
    private String lastName;
    private String middleName;
    private Date birthDate;
    private String gender;

    public Long getPersonId() {
        return personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return Objects.equals(personId, personDTO.personId) && Objects.equals(firstName, personDTO.firstName) && Objects.equals(lastName, personDTO.lastName) && Objects.equals(middleName, personDTO.middleName) && Objects.equals(birthDate, personDTO.birthDate) && Objects.equals(gender, personDTO.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, firstName, lastName, middleName, birthDate, gender);
    }
}
