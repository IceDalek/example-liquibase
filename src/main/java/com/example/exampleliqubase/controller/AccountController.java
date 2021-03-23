package com.example.exampleliqubase.controller;

import java.util.List;

import com.example.exampleliqubase.api.AccountService;
import com.example.exampleliqubase.dto.AccountDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/save")
    public AccountDTO saveAccount(@RequestBody @Validated AccountDTO accountDTO) {
        return accountService.save(accountDTO);
    }

    @PostMapping("/list")
    public List<AccountDTO> getListAccounts() {
        return accountService.getListAccounts();
    }
}
