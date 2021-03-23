package com.example.exampleliqubase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountEntity {
    private Long userId;

    private String username;

    private String password;

    private String country;
}
