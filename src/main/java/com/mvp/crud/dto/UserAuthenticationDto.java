package com.mvp.crud.dto;

import com.mvp.crud.model.SoldierEntity;
import com.mvp.crud.model.SpouseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAuthenticationDto {
    private boolean isAuthenticated;
    private SoldierEntity soldierEntity;
    private SpouseEntity spouseEntity;
    private String token;

    public UserAuthenticationDto() {
        this.isAuthenticated = false;
    }

}
