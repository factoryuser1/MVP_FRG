package com.mvp.crud.controller;

import com.mvp.crud.impl.SpouseServiceImpl;
import com.mvp.crud.model.SpouseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/frg/spouse")
@ControllerAdvice
@RequiredArgsConstructor
public class SpouseController {

    private final SpouseServiceImpl spouseServiceImpl;

    //1. find all Spouses
    @GetMapping
    public Iterable<SpouseEntity> findSpouses() {
        return spouseServiceImpl.findAllSpouses();
    }

    //2. find SpouseEntity by id
    @GetMapping("/{id}")
    public SpouseEntity findSpouseById(@PathVariable Long id) {
        return spouseServiceImpl.findSpouseById(id);
    }

    //3. add a new spouseEntity
    @PostMapping
    public SpouseEntity addSpouse(@RequestBody SpouseEntity spouseEntity){
        return spouseServiceImpl.addSpouse(spouseEntity);
    }

}
