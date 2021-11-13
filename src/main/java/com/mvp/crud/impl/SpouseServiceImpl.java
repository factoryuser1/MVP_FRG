package com.mvp.crud.impl;

import com.mvp.crud.dto.SpouseDto;
import com.mvp.crud.exception.ResourceNotFoundException;
import com.mvp.crud.model.SpouseEntity;
import com.mvp.crud.repository.SoldierRepository;
import com.mvp.crud.repository.SpouseRepository;
import com.mvp.crud.service.SpouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor//for the repository injection
public class SpouseServiceImpl implements SpouseService {

    private final SpouseRepository spouseRepository;
    private final SoldierRepository soldierRepository;

    @Override
    public Iterable<SpouseEntity> findAllSpouses() {
        return spouseRepository.findAll();
    }

    @Override
    public SpouseDto findSpouseById(Long id) {
        //get spouse by id
        SpouseEntity spouseEntityToFind = spouseRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Spouse", "id", id));
        //convert entity to dto and return to controller to return to front-end without exposing the entity
        return convertSpouseEntityToDto(spouseEntityToFind);
    }

    @Override
    public SpouseDto addSpouse(SpouseDto spouseDto) {
        //convert dto to entity
        SpouseEntity spouseEntityToAdd = convertSpouseDtoToEntity(spouseDto);
        //save entity to database
        SpouseEntity spouseEntitySaved = spouseRepository.save(spouseEntityToAdd);
        //convert entity to dto and return to controller to return to front-end without exposing the entity
        return convertSpouseEntityToDto(spouseEntitySaved);
    }


    @Override
    public SpouseDto updateSpouse(Long id, SpouseDto spouseDto) {
        //get spouse by id from database
        SpouseEntity spouseEntityToUpdate = spouseRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Spouse", "id", id));
        //update spouse entity with new values from dto object
        //(to be refactored to automatically map the DTO fields to the entity fields using ModelMapper of ObjectMapper)
        spouseEntityToUpdate.setId(spouseDto.getId());
        spouseEntityToUpdate.setSoldierId(spouseDto.getSoldierId());
        spouseEntityToUpdate.setFirstName(spouseDto.getFirstName());
        spouseEntityToUpdate.setLastName(spouseDto.getLastName());
        spouseEntityToUpdate.setEmail(spouseDto.getEmail());
        spouseEntityToUpdate.setComplete(spouseDto.isComplete());
        spouseEntityToUpdate.setPhone(spouseDto.getPhone());
        spouseEntityToUpdate.setAddress(spouseDto.getAddress());
        spouseEntityToUpdate.setCity(spouseDto.getCity());
        spouseEntityToUpdate.setState(spouseDto.getState());
        spouseEntityToUpdate.setZip(spouseDto.getZip());
        spouseEntityToUpdate.setOccupation(spouseDto.getOccupation());
        spouseEntityToUpdate.setCompany(spouseDto.getCompany());
        //save updated spouse entity to database and return the successfully updated spouse entity after saving
        SpouseEntity updatedSpouseEntity = spouseRepository.save(spouseEntityToUpdate);
        //convert updated spouse entity to dto and return to controller to return to front-end without exposing the DAO entity
        return convertSpouseEntityToDto(updatedSpouseEntity);
    }

    @Override
    public void deleteSpouse(Long id) {
        //get spouse by id from database
        SpouseEntity spouseEntityToDelete = spouseRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Spouse", "id", id));
        //delete spouse entity from database
        spouseRepository.delete(spouseEntityToDelete);
    }

    //convert SpouseEntity to SpouseDto using the @Builder annotation on DTO
    public SpouseDto convertSpouseEntityToDto(SpouseEntity spouseEntity){
        return SpouseDto.builder()
                .id(spouseEntity.getId())
                .soldierId(spouseEntity.getSoldierId())
                .firstName(spouseEntity.getFirstName())
                .lastName(spouseEntity.getLastName())
                .email(spouseEntity.getEmail())
                .isComplete(spouseEntity.isComplete())
                .phone(spouseEntity.getPhone())
                .address(spouseEntity.getAddress())
                .city(spouseEntity.getCity())
                .state(spouseEntity.getState())
                .zip(spouseEntity.getZip())
                .occupation(spouseEntity.getOccupation())
                .company(spouseEntity.getCompany())
                .build();
    }

    //convert SpouseDto to SpouseEntity using the @Builder annotation on Entity
    public SpouseEntity convertSpouseDtoToEntity(SpouseDto spouseDto){
        return SpouseEntity.builder()
                .id(spouseDto.getId())
                .soldierId(spouseDto.getSoldierId())
                .firstName(spouseDto.getFirstName())
                .lastName(spouseDto.getLastName())
                .email(spouseDto.getEmail())
                .isComplete(spouseDto.isComplete())
                .phone(spouseDto.getPhone())
                .address(spouseDto.getAddress())
                .city(spouseDto.getCity())
                .state(spouseDto.getState())
                .zip(spouseDto.getZip())
                .occupation(spouseDto.getOccupation())
                .company(spouseDto.getCompany())
                .build();
    }
}