package com.mvp.crud.service;

import com.mvp.crud.model.Spouse;
import com.mvp.crud.repository.SpouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpouseService {

    private final SpouseRepository spouseRepository;

    public Iterable<Spouse> findAll() {
        return spouseRepository.findAll();
    }

    public Spouse findById(Long id) {
        return spouseRepository.findById(id).orElse(null);
    }

}