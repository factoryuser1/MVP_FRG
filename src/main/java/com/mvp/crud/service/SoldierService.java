package com.mvp.crud.service;

import com.mvp.crud.dto.SoldierDto;
import com.mvp.crud.model.SoldierEntity;

public interface SoldierService {
    Iterable<SoldierEntity> findAllSoldiers();
    SoldierDto findSoliderById(Long id);
    SoldierDto addSolider(SoldierDto soliderDto);
    SoldierDto updateSolider(Long id, SoldierDto soliderDto);
    void deleteSoldier(Long id);
}
