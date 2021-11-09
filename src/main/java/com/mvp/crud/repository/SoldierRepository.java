package com.mvp.crud.repository;

import com.mvp.crud.model.Soldier;
import org.springframework.data.repository.CrudRepository;

public interface SoldierRepository extends CrudRepository<Soldier, Long> {

}
