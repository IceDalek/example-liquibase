package com.example.exampleliqubase.api;

import java.util.List;

import com.example.exampleliqubase.dto.AccountDTO;

public interface AccountService {
    AccountDTO save(AccountDTO accountDTO);

    List<AccountDTO> getListAccounts();

}
