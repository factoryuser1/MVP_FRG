package com.mvp.crud.service;

import com.mvp.crud.dto.SpouseDto;
import com.mvp.crud.model.SpouseEntity;

public interface SpouseService {
    Iterable<SpouseEntity> findAllSpouses();
    SpouseDto findSpouseById(Long id);
    SpouseDto addSpouse(SpouseDto spouseDto);
    SpouseDto updateSpouse(Long id, SpouseDto spouseDto);
    void deleteSpouse(Long id);
}
