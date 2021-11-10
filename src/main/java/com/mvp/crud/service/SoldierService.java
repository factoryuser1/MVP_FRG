package com.mvp.crud.service;

import com.mvp.crud.dto.SoldierDto;
import com.mvp.crud.model.Soldier;

public interface SoldierService {
    Iterable<Soldier> findAllSoldiers();
    Soldier findSoliderById(Long id);
    Soldier addSolider(Soldier solider);
    SoldierDto updateSolider(Long id, SoldierDto soliderDto);
    void deleteSoldier(Long id);
}
