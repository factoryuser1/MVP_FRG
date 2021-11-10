package com.mvp.crud.controller;

import com.mvp.crud.dto.SpouseDto;
import com.mvp.crud.impl.SpouseServiceImpl;
import com.mvp.crud.model.Spouse;
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
    public Iterable<Spouse> findSpouses() {
        return spouseServiceImpl.findAllSpouses();
    }

    //2. find Spouse by id
    @GetMapping("/{id}")
    public Spouse findSpouseById(@PathVariable Long id) {
        return spouseServiceImpl.findSpouseById(id);
    }

    //3. add a new spouse
    @PostMapping
    public Spouse addSpouse(@RequestBody Spouse spouse){
        return spouseServiceImpl.addSpouse(spouse);
    }

}
