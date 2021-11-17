package com.mvp.crud.controller;

import com.mvp.crud.dto.SpouseDto;
import com.mvp.crud.impl.SpouseServiceImpl;
import com.mvp.crud.model.SpouseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/frg/spouse")
@ControllerAdvice
@RequiredArgsConstructor //for the service injection
public class SpouseController {

    private final SpouseServiceImpl spouseServiceImpl;

    //1. find all Spouses
    @GetMapping
    public Iterable<SpouseEntity> findSpouses() {
        return spouseServiceImpl.findAllSpouses();
    }

    //2. find spouse by id
    @GetMapping("/{id}")
    public ResponseEntity<SpouseDto> findSpouseById(@PathVariable(name = "id") Long id) {
        SpouseDto spouseResponseDTO = spouseServiceImpl.findSpouseById(id);
        return new ResponseEntity<>(spouseResponseDTO, HttpStatus.OK);
    }

    //3. add a new spouse
    @PostMapping
    public ResponseEntity<SpouseDto> addSpouse(@RequestBody SpouseDto spouseDto){
        SpouseDto spouseResponseDTO = spouseServiceImpl.addSpouse(spouseDto);
        return new ResponseEntity<>(spouseResponseDTO, HttpStatus.CREATED);
    }

    //4. update a specific spouse by id
    @PatchMapping("/{id}")
    public ResponseEntity<SpouseDto> updateSpouse(@PathVariable (name = "id") Long id, @RequestBody SpouseDto spouseDto){
        SpouseDto spouseResponseDTO = spouseServiceImpl.updateSpouse(id, spouseDto);
        return new ResponseEntity<>(spouseResponseDTO, HttpStatus.ACCEPTED);
    }

    //5. delete a spouseEntity
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSpouse(@PathVariable Long id){
        spouseServiceImpl.deleteSpouse(id);
        return new ResponseEntity<>(String.format("Spouse with id %d has been deleted successfully.", id), HttpStatus.NO_CONTENT);
    }

}
