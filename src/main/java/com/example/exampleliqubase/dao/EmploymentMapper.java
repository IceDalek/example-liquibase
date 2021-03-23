package com.example.exampleliqubase.dao;

import com.example.exampleliqubase.model.EmploymentEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EmploymentMapper {
    @SelectKey(resultType = Long.class, keyProperty = "employment_id", before = true,
            statement = "select nextval('employment_seq')")
    @Insert("insert into employment(employment_id, version, start_dt, end_dt, work_type_id, organization_name, organization_address, position_name, person_id)\n" +
            "    values(#{employment_id}, #{version} ,#{start_dt} ,#{end_dt},#{work_type_id},\n" +
            "        #{organization_name},#{organization_address},#{position_name},#{person_id})    ")
    void save(EmploymentEntity employmentEntity);
}


