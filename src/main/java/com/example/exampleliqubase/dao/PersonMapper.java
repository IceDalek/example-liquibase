package com.example.exampleliqubase.dao;

import com.example.exampleliqubase.model.PersonEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PersonMapper {
    @SelectKey(resultType = Long.class, keyProperty = "personId", before = true,
            statement = "select nextval('person_seq')")
    @Insert("insert into person(person_id, first_name, last_name, middle_name, birth_date, gender) " +
            "values (#{personId}, #{firstName} ,#{lastName}, #{middleName}, #{birthDate}, #{gender}  )")
    void savePerson(PersonEntity personEntity);

    @Select("Select * from person where person_id = #{id}")
    PersonEntity getPersonById(Long id);


}
