package com.mvp.crud.repository;

import com.mvp.crud.model.SoldierEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SoldierRepository extends CrudRepository<SoldierEntity, Long> {
    Optional<SoldierEntity> findSoldierByLastNameAndFirstName(String firstName, String lastName);
    Optional<SoldierEntity> findSoldierByDodId(String dodId);
    Optional<SoldierEntity> findSoldierByEmail(String email);
    Optional<SoldierEntity> findSoldierByPhone(String phoneNumber);
}
