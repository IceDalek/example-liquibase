package com.example.exampleliqubase.controller;

import java.util.List;

import com.example.exampleliqubase.api.AccountService;
import com.example.exampleliqubase.api.EmploymentService;
import com.example.exampleliqubase.api.PersonService;
import com.example.exampleliqubase.dto.AccountDTO;

import com.example.exampleliqubase.dto.EmploymentDTO;
import com.example.exampleliqubase.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;


    @PostMapping("/list")
    public List<AccountDTO> getListAccounts() {
        return accountService.getListAccounts();
    }
}
