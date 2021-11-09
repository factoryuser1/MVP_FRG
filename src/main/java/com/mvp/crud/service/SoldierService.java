package com.mvp.crud.service;

import com.mvp.crud.model.Soldier;
import com.mvp.crud.repository.SoldierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //for the repository injection

public class SoldierService {
    private final SoldierRepository soldierRepository;

    public Iterable <Soldier> findAll() {
        return soldierRepository.findAll();
    }

    public Soldier findById(Long id) {
        return soldierRepository.findById(id).orElse(null);
    }

}

//public class SoldierService {
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