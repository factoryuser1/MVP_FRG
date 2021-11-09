package com.mvp.crud.service;

import com.mvp.crud.model.Soldier;

public interface SoliderService {
    Iterable<Soldier> findAllSoldiers();
    Soldier findSoliderById(Long id);
//    public void addSolider(Soldier solider);
//    public void updateSolider(Soldier solider);
//    public void deleteSolider(int id);
}
