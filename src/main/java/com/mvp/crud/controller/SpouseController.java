package com.mvp.crud.controller;

import com.mvp.crud.model.Spouse;
import com.mvp.crud.service.SpouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/frg/spouse")
@ControllerAdvice
@RequiredArgsConstructor
public class SpouseController {

    private final SpouseService spouseService;

    @GetMapping
    public Iterable<Spouse> findSpouses() {
        return spouseService.findAll();
    }

    @GetMapping("/{id}")
    public Spouse findSpouseById(@PathVariable Long id) {
        return spouseService.findById(id);
    }

}
