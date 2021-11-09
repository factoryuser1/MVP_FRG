package com.mvp.crud.impl;

import com.mvp.crud.model.Spouse;
import com.mvp.crud.repository.SpouseRepository;
import com.mvp.crud.service.SpouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpouseServiceImpl implements SpouseService {

    private final SpouseRepository spouseRepository;
    @Override
    public Iterable<Spouse> findAllSpouses() {
        return spouseRepository.findAll();
    }
    @Override
    public Optional<Spouse> findSpouseById(Long id) {
        return spouseRepository.findById(id).orElse(null);
    }

}