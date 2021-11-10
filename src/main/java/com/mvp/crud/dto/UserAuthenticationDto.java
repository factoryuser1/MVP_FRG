package com.mvp.crud.dto;

import com.mvp.crud.model.Soldier;
import com.mvp.crud.model.Spouse;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAuthenticationDto {
    private boolean isAuthenticated;
    private Soldier soldier;
    private Spouse spouse;
    private String token;

    public UserAuthenticationDto() {
        this.isAuthenticated = false;
    }

}
