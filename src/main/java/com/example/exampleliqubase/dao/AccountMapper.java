package com.example.exampleliqubase.dao;

import java.util.List;

import com.example.exampleliqubase.model.AccountEntity;

import com.example.exampleliqubase.model.EmploymentEntity;
import com.example.exampleliqubase.model.PersonEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountMapper {

    @SelectKey(resultType = Long.class, keyProperty = "userId", before = true,
            statement = "select nextval('account_entity_liquibase_seq')")
    @Insert("insert into account_entity_liquibase (user_id, username, password, country) " +
            "values (#{userId}, #{username} ,#{password} ,#{country} )")
    void save(AccountEntity accountEntity);

    @Select("select * from account_entity_liquibase")
    List<AccountEntity> getListAccounts();




}
