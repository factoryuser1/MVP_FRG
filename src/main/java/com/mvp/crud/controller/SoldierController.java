package com.mvp.crud.controller;

import com.mvp.crud.dto.SoldierDto;
import com.mvp.crud.impl.SoldierServiceImpl;
import com.mvp.crud.model.SoldierEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/frg/soldier")
@ControllerAdvice
@RequiredArgsConstructor //for the service injection
public class SoldierController {

    private final SoldierServiceImpl soldierServiceImpl;

    //1. find all soldiers
    @GetMapping
    public Iterable<SoldierEntity> findAllSoldiers() {
        return soldierServiceImpl.findAllSoldiers();
    }

    //2. find soldier by id
    @GetMapping("/{id}")
    public ResponseEntity<SoldierDto> findSoldierById(@PathVariable(name = "id") Long id) {
        SoldierDto soldierResponseDTO = soldierServiceImpl.findSoliderById(id);
        return new ResponseEntity<>(soldierResponseDTO, HttpStatus.FOUND);
    }

    //3. add a new soldier
    @PostMapping
    public ResponseEntity<SoldierDto> addSoldier(@RequestBody SoldierDto soldierDto) {
        SoldierDto soldierResponseDTO = soldierServiceImpl.addSolider(soldierDto);
        return new ResponseEntity<>(soldierResponseDTO, HttpStatus.CREATED);
    }

    //4. update a specific soldier by id
    @PatchMapping("/{id}")
    public ResponseEntity<SoldierDto> updateSoldier(@PathVariable(name = "id") Long id, @RequestBody SoldierDto soldierDto) {
        SoldierDto soldierResponseDTO = soldierServiceImpl.updateSolider(id, soldierDto);
        return new ResponseEntity<>(soldierResponseDTO, HttpStatus.OK);
    }

    //5. delete soldier by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSoldier(@PathVariable Long id) {
        soldierServiceImpl.deleteSoldier(id);
        return new ResponseEntity<>(String.format("Soldier with id %d has been deleted successfully.", id), HttpStatus.OK);
    }

}