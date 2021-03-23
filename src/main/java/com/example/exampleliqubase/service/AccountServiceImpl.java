package com.example.exampleliqubase.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import com.example.exampleliqubase.api.AccountService;
import com.example.exampleliqubase.dao.AccountMapper;
import com.example.exampleliqubase.dto.AccountDTO;
import com.example.exampleliqubase.model.AccountEntity;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void init() {
        System.out.println();
    }

    @Override
    @Transactional
    public AccountDTO save(AccountDTO accountDTO) {

        AccountEntity accountEntity = modelMapper.map(accountDTO, AccountEntity.class);
        //тут какая-то логика
        accountMapper.save(accountEntity);

        //тут еще какая-то логика

        return modelMapper.map(accountEntity, AccountDTO.class);
    }

    @Override
    public List<AccountDTO> getListAccounts() {
       return accountMapper.getListAccounts().stream()
                .map(accountEntity -> modelMapper.map(accountEntity, AccountDTO.class))
                .collect(Collectors.toList());
    }
}
