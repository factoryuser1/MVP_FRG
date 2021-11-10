package com.mvp.crud.impl;

import com.mvp.crud.dto.SpouseDto;
import com.mvp.crud.model.Spouse;
import com.mvp.crud.repository.SpouseRepository;
import com.mvp.crud.service.SpouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpouseServiceImpl implements SpouseService {

    private final SpouseRepository spouseRepository;

    @Override
    public Iterable<Spouse> findAllSpouses() {
        return spouseRepository.findAll();
    }

    @Override
    public Spouse findSpouseById(Long id) {
        return spouseRepository.findById(id).orElse(null);
    }

    @Override
    public Spouse addSpouse(Spouse spouse) {
        return spouseRepository.save(spouse);
    }

}