package com.mvp.crud.repository;

import com.mvp.crud.model.SoldierEntity;
import org.springframework.data.repository.CrudRepository;

public interface SoldierRepository extends CrudRepository<SoldierEntity, Long> {

}
