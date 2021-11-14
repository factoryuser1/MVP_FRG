package com.mvp.crud.repository;

import com.mvp.crud.model.SpouseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpouseRepository extends CrudRepository<SpouseEntity, Long> {
    Optional<SpouseEntity> findSpouseBySoldierId(Long soldierId);
}
