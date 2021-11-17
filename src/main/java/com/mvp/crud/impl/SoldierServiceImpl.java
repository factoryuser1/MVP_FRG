package com.mvp.crud.impl;

import com.mvp.crud.dto.SoldierDto;
import com.mvp.crud.exception.ResourceNotFoundException;
import com.mvp.crud.model.SoldierEntity;
import com.mvp.crud.repository.SoldierRepository;
import com.mvp.crud.repository.SpouseRepository;
import com.mvp.crud.service.SoldierService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //for the repository injection
public class SoldierServiceImpl implements SoldierService {

    private final SoldierRepository soldierRepository;
    private final SpouseRepository spouseRepository;

    @Override
    public Iterable<SoldierEntity> findAllSoldiers() {
        return soldierRepository.findAll();
    }

    @Override
    public SoldierDto findSoliderById(Long id) {
        //get soldier by id
        SoldierEntity soldierEntityToFind = soldierRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Soldier", "id", id));
        //convert entity to dto and return to controller to return to front-end without exposing the entity
        return convertSoldierEntityToDto(soldierEntityToFind);
    }

    @Override
    public SoldierDto addSolider(SoldierDto soldierDto) {
        //convert dto to entity
        SoldierEntity soldierEntityToAdd = convertSoldierDtoToEntity(soldierDto);
        //save entity to DB and repository will return the saved entity
        SoldierEntity savedSoldierEntity = soldierRepository.save(soldierEntityToAdd);
        //convert entity to dto and return to controller to return to front-end without exposing the entity
        return convertSoldierEntityToDto(savedSoldierEntity);
    }

    @Override
    public SoldierDto updateSolider(Long id, SoldierDto soldierDto) {
        //get soldier by id from the database
        SoldierEntity soldierEntityToUpdate = soldierRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Soldier", "id", id));
        //update soldier (to be refactored to automatically map the DTO fields to the entity fields using ModelMapper of ObjectMapper)
//        soldierEntityToUpdate.setId(soldierDto.getId());
        soldierEntityToUpdate.setFirstName(soldierDto.getFirstName());
        soldierEntityToUpdate.setLastName(soldierDto.getLastName());
        soldierEntityToUpdate.setSoldierRank(soldierDto.getSoldierRank());
        soldierEntityToUpdate.setMarried(soldierDto.isMarried());
        soldierEntityToUpdate.setUnit(soldierDto.getUnit());
        soldierEntityToUpdate.setEmail(soldierDto.getEmail());
        soldierEntityToUpdate.setGender(soldierDto.getGender());
        soldierEntityToUpdate.setAddress(soldierDto.getAddress());
        soldierEntityToUpdate.setCity(soldierDto.getCity());
        soldierEntityToUpdate.setState(soldierDto.getState());
        soldierEntityToUpdate.setZip(soldierDto.getZip());
        soldierEntityToUpdate.setAge(soldierDto.getAge());
        soldierEntityToUpdate.setPhone(soldierDto.getPhone());
        soldierEntityToUpdate.setDOB(soldierDto.getDOB());
        soldierEntityToUpdate.setDodId(soldierDto.getDodId());
        //save updated soldier to DB and return the successfully updated soldier after saving
        SoldierEntity updatedSoldierEntity = soldierRepository.save(soldierEntityToUpdate);
        //convert updated soldier to dto and return to controller to return to front end without exposing the DAO entity
        return convertSoldierEntityToDto(updatedSoldierEntity);
    }

    @Override
    public void deleteSoldier(Long id) {
        //get soldier by id
        SoldierEntity soldierEntityToDelete = soldierRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Soldier", "id", id));
        soldierRepository.delete(soldierEntityToDelete);
        //or
        //soldierRepository.deleteById(id);
    }

    //convert SoldierEntity Entity to dto using the @Builder annotation on DTO
    public SoldierDto convertSoldierEntityToDto(SoldierEntity soldierEntity) {
        return SoldierDto.builder()
                .id(soldierEntity.getId())
                .firstName(soldierEntity.getFirstName())
                .lastName(soldierEntity.getLastName())
                .soldierRank(soldierEntity.getSoldierRank())
                .isMarried(soldierEntity.isMarried())
                .unit(soldierEntity.getUnit())
                .age(soldierEntity.getAge())
                .gender(soldierEntity.getGender())
                .email(soldierEntity.getEmail())
                .address(soldierEntity.getAddress())
                .city(soldierEntity.getCity())
                .state(soldierEntity.getState())
                .zip(soldierEntity.getZip())
                .phone(soldierEntity.getPhone())
                .DOB(soldierEntity.getDOB())
                .dodId(soldierEntity.getDodId())
                .build();
    }

    //convert SoldierEntity dto to Entity using the @Builder annotation on DTO
    public SoldierEntity convertSoldierDtoToEntity(SoldierDto soldierDto) {
        return SoldierEntity.builder()
                .id(soldierDto.getId())
                .firstName(soldierDto.getFirstName())
                .lastName(soldierDto.getLastName())
                .email(soldierDto.getEmail())
                .soldierRank(soldierDto.getSoldierRank())
                .isMarried(soldierDto.isMarried())
                .unit(soldierDto.getUnit())
                .age(soldierDto.getAge())
                .gender(soldierDto.getGender())
                .address(soldierDto.getAddress())
                .city(soldierDto.getCity())
                .state(soldierDto.getState())
                .zip(soldierDto.getZip())
                .phone(soldierDto.getPhone())
                .DOB(soldierDto.getDOB())
                .dodId(soldierDto.getDodId())
                .build();
    }
}
