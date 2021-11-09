package com.mvp.crud.controller;

import com.mvp.crud.model.Spouse;
import com.mvp.crud.impl.SpouseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
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
    public Optional<Spouse> findSpouseById(@PathVariable Long id) {
        return spouseServiceImpl.findSpouseById(id);
    }

}
