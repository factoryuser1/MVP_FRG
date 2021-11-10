package com.mvp.crud.service;

import com.mvp.crud.dto.SpouseDto;
import com.mvp.crud.model.Spouse;

public interface SpouseService {
    Iterable<Spouse> findAllSpouses();
    Spouse findSpouseById(Long id);
    Spouse addSpouse(Spouse spouse);
}
