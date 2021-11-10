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
    public SoldierDto findSoliderById(Long id) {
        //get soldier by id
        Soldier soldierToFind = soldierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Soldier", "id", id));
        //convert entity to dto and return to controller to return to front-end without exposing the entity
        return convertSoldierEntityToDto(soldierToFind);
    }

    @Override
    public SoldierDto addSolider(SoldierDto soldierDto) {
        //convert dto to entity
        Soldier soldierToAdd = convertSoldierDtoToEntity(soldierDto);
        //save entity to DB
        Soldier savedSoldier = soldierRepository.save(soldierToAdd);
        //convert entity to dto and return to controller to return to front-end without exposing the entity
        return convertSoldierEntityToDto(savedSoldier);
    }

    @Override
    public SoldierDto updateSolider(Long id, SoldierDto soldierDto) {
        //get soldier by id from the database
        Soldier soldierToUpdate = soldierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Soldier", "id", id));
        //update soldier (to be refactored to automatically map the DTO fields to the entity fields using ModelMapper of ObjectMapper)
        soldierToUpdate.setFirstName(soldierDto.getFirstName());
        soldierToUpdate.setLastName(soldierDto.getLastName());
        soldierToUpdate.setSoldierRank(soldierDto.getSoldierRank());
        soldierToUpdate.setMarried(soldierDto.isMarried());
        soldierToUpdate.setUnit(soldierDto.getUnit());
        soldierToUpdate.setAge(soldierDto.getAge());
        soldierToUpdate.setGender(soldierDto.getGender());
        soldierToUpdate.setAddress(soldierDto.getAddress());
        soldierToUpdate.setCity(soldierDto.getCity());
        soldierToUpdate.setState(soldierDto.getState());
        soldierToUpdate.setZip(soldierDto.getZip());
        soldierToUpdate.setAge(soldierDto.getAge());
        soldierToUpdate.setPhone(soldierDto.getPhone());
        soldierToUpdate.setDOB(soldierDto.getDOB());
        soldierToUpdate.setDodId(soldierDto.getDodId());
        //save updated soldier to DB and return the successfully updated soldier after saving
        Soldier updatedSoldier = soldierRepository.save(soldierToUpdate);
        //convert updated soldier to dto and return to controller to return to front end without exposing the entity
        return convertSoldierEntityToDto(updatedSoldier);
    }

    @Override
    public void deleteSoldier(Long id) {
        //get soldier by id
        Soldier soldierToDelete = soldierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Soldier", "id", id));
        soldierRepository.delete(soldierToDelete);
        //or
        //soldierRepository.deleteById(id);
    }

    //convert Soldier Entity to dto using the @Builder annotation on DTO
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

    //convert Soldier dto to Entity using the @Builder annotation on DTO
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
