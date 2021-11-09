package com.mvp.crud.impl;

import com.mvp.crud.model.Soldier;
import com.mvp.crud.repository.SoldierRepository;
import com.mvp.crud.service.SoliderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //for the repository injection
public class SoldierServiceImpl implements SoliderService {

    private final SoldierRepository soldierRepository;
    @Override
    public Iterable<Soldier> findAllSoldiers() {
        return soldierRepository.findAll();
    }
    @Override
    public Soldier findSoliderById(Long id) {
        return soldierRepository.findById(id).orElse(null);
    }

}

//public class SoldierServiceImpl {
//
//    private final SoldierRepository soldierRepository;
//
//    public Soldier saveSoldier(Soldier soldier){
//        return soldierRepository.save(soldier);
//    }
//
//    public Soldier getSoldier(Long id){
//        return soldierRepository.findById(id).get();
//    }
//
//    public void deleteSoldier(Long id){
//        soldierRepository.deleteById(id);
//    }
//}