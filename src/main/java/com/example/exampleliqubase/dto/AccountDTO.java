package com.example.exampleliqubase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private Long userId;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String country;
}
