package com.mvp.crud.controller;

import com.mvp.crud.model.Soldier;
import com.mvp.crud.service.SoldierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/frg/soldier")
@ControllerAdvice
@RequiredArgsConstructor //for the service injection
public class SoldierController {

    public final SoldierService soldierService;
    //1. find all soldiers
    @GetMapping
    public Iterable<Soldier> findAll() {
        return soldierService.findAll();
    }

    //2. find soldier by id
    @GetMapping("/{id}")
    public Soldier findSoldierById(@PathVariable Long id) {
        return soldierService.findById(id);
    }

    @PostMapping
    public Soldier saveSoldier(@RequestBody Soldier soldier) {
        return soldierService.save(soldier);
    }

    @PutMapping("/{id}")
    public Soldier updateSoldier(@PathVariable Long id, @RequestBody Soldier soldier) {
        return soldierService.update(id, soldier);
    }

    @DeleteMapping("/{id}")
    public void deleteSoldier(@PathVariable Long id) {
        soldierService.delete(id);
    }
}

}
