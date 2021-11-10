package com.mvp.crud.impl;

import com.mvp.crud.dto.SoldierDto;
import com.mvp.crud.exception.ResourceNotFoundException;
import com.mvp.crud.model.Soldier;
import com.mvp.crud.repository.SoldierRepository;
import com.mvp.crud.service.SoldierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //for the repository injection
public class SoldierServiceImpl implements SoldierService {

    private final SoldierRepository soldierRepository;

    @Override
    public Iterable<Soldier> findAllSoldiers() {
        return soldierRepository.findAll();
    }

    @Override
    public Soldier findSoliderById(Long id) {
        return soldierRepository.findById(id).orElse(null);
    }

    @Override
    public Soldier addSolider(Soldier soldier) {
        return soldierRepository.save(soldier);
    }

    @Override
    public SoldierDto updateSolider(Long id, SoldierDto soldierDto) {
        //get soldier by id
        Soldier soldierToUpdate = soldierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Soldier", "id", id));

        return soldierRepository.save(soldierToUpdate);
    }

    @Override
    public void deleteSoldier(Long id) {
        //get soldier by id
        Soldier soldierToDelete = soldierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Soldier", "id", id));
        soldierRepository.deleteById(id);
    }

    //convert Soldier Entity to dto
    public SoldierDto convertSoldierEntityToDto(Soldier soldier) {
        return SoldierDto.builder()
                .id(soldier.getId())
                .firstName(soldier.getFirstName())
                .firstName(soldier.getFirstName())
                .lastName(soldier.getLastName())
                .soldierRank(soldier.getSoldierRank())
                .isMarried(soldier.isMarried())
                .unit(soldier.getUnit())
                .age(soldier.getAge())
                .gender(soldier.getGender())
                .address(soldier.getAddress())
                .city(soldier.getCity())
                .state(soldier.getState())
                .zip(soldier.getZip())
                .age(soldier.getAge())
                .phone(soldier.getPhone())
                .DOB(soldier.getDOB())
                .dodId(soldier.getDodId())
                .build();
    }

    //convert Soldier dto to Entity
    public Soldier convertSoldierDtoToEntity(SoldierDto soldierDto) {
        return Soldier.builder()
                .id(soldierDto.getId())
                .firstName(soldierDto.getFirstName())
                .firstName(soldierDto.getFirstName())
                .lastName(soldierDto.getLastName())
                .soldierRank(soldierDto.getSoldierRank())
                .isMarried(soldierDto.isMarried())
                .unit(soldierDto.getUnit())
                .age(soldierDto.getAge())
                .gender(soldierDto.getGender())
                .address(soldierDto.getAddress())
                .city(soldierDto.getCity())
                .state(soldierDto.getState())
                .zip(soldierDto.getZip())
                .age(soldierDto.getAge())
                .phone(soldierDto.getPhone())
                .DOB(soldierDto.getDOB())
                .dodId(soldierDto.getDodId())
                .build();

    }
}
