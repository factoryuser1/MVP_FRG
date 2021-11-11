package com.mvp.crud.service;

import com.mvp.crud.model.SpouseEntity;

public interface SpouseService {
    Iterable<SpouseEntity> findAllSpouses();
    SpouseEntity findSpouseById(Long id);
    SpouseEntity addSpouse(SpouseEntity spouseEntity);
}
