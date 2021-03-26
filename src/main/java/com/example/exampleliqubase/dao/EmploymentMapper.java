package com.example.exampleliqubase.dao;

import com.example.exampleliqubase.model.EmploymentEntity;
import com.example.exampleliqubase.model.PersonEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EmploymentMapper {
    @SelectKey(resultType = Long.class, keyProperty = "employmentId", before = true,
            statement = "select nextval('employment_seq')")
    @Insert("insert into employment(employment_id, version, start_dt, end_dt, work_type_id, organization_name, organization_address, position_name, person_id)\n" +
            "    values(#{employmentId}, #{version} ,#{startDt} ,#{endDt},#{workTypeId},\n" +
            "        #{organizationName},#{organizationAddress},#{positionName},#{personId})    ")
    void save(EmploymentEntity employmentEntity);

    @Select("Select * from employment where employment_id = #{id}")
    EmploymentEntity getEmploymentById(Long id);

    @Update("Update employment set" +
            " version =  #{version}," +
            " start_dt = #{startDt}, end_dt = #{endDt}," +
            " work_type_id = #{workTypeId}, organization_name = #{organizationName}," +
            " organization_address = #{organizationAddress}," +
            " position_name= #{positionName}, person_id = #{personId} WHERE employment_id = #{employmentId}")
    void updateEmployment(EmploymentEntity employmentEntity);

}


