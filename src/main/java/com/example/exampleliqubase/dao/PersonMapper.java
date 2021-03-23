package com.example.exampleliqubase.dao;

import com.example.exampleliqubase.model.PersonEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PersonMapper {
    @SelectKey(resultType = Long.class, keyProperty = "person_id", before = true,
            statement = "select nextval('person_seq')")
    @Insert("insert into person(person_id, first_name, last_name, middle_name, birth_date, gender) " +
            "values (#{person_id}, #{first_name} ,#{last_name} ,#{middle_name},#{birth_date},#{gender}  )")
    void savePerson(PersonEntity personEntity);
}
