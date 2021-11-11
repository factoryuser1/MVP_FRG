package com.mvp.crud.impl;

import com.mvp.crud.model.SpouseEntity;
import com.mvp.crud.repository.SpouseRepository;
import com.mvp.crud.service.SpouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpouseServiceImpl implements SpouseService {

    private final SpouseRepository spouseRepository;

    @Override
    public Iterable<SpouseEntity> findAllSpouses() {
        return spouseRepository.findAll();
    }

    @Override
    public SpouseEntity findSpouseById(Long id) {
        return spouseRepository.findById(id).orElse(null);
    }

    @Override
    public SpouseEntity addSpouse(SpouseEntity spouseEntity) {
        return spouseRepository.save(spouseEntity);
    }

}