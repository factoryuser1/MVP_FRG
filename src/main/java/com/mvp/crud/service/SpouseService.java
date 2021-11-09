package com.mvp.crud.service;

import com.mvp.crud.model.Spouse;

import java.util.Optional;

public interface SpouseService {
    Iterable<Spouse> findAllSpouses();
    Optional<Spouse> findSpouseById(Long id);
}
