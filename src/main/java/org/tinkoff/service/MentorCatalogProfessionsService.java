package org.tinkoff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tinkoff.database.entity.MentorHasCatalogProfessionsId;
import org.tinkoff.database.repository.MentorCatalogProfessionsRepository;
import org.tinkoff.dto.mentor_catalog.MentorCatalogProfessionsCreateEditDto;
import org.tinkoff.dto.mentor_catalog.MentorHasCatalogProfessionsReadDto;
import org.tinkoff.mapper.mentorcatalog.MentorHasCatalogProfessionsCreateEditMapper;
import org.tinkoff.mapper.mentorcatalog.MentorHasCatalogProfessionsReadMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MentorCatalogProfessionsService {
    private final MentorCatalogProfessionsRepository mentorCatalogProfessionsRepository;
    private final MentorHasCatalogProfessionsCreateEditMapper mentorHasCatalogProfessionsCreateEditMapper;
    private final MentorHasCatalogProfessionsReadMapper mentorHasCatalogProfessionsReadMapper;

    public List<MentorHasCatalogProfessionsReadDto> findAll() {
        return mentorCatalogProfessionsRepository
                .findAll()
                .stream()
                .map(mentorHasCatalogProfessionsReadMapper::map)
                .toList();
    }

    public Optional<MentorHasCatalogProfessionsReadDto> findById(MentorHasCatalogProfessionsId id) {
        return mentorCatalogProfessionsRepository
                .findById(id)
                .map(mentorHasCatalogProfessionsReadMapper::map);
    }

    @Transactional
    public MentorHasCatalogProfessionsReadDto create(MentorCatalogProfessionsCreateEditDto dto) {
        return Optional.of(dto)
                .map(mentorHasCatalogProfessionsCreateEditMapper::map)
                .map(mentorCatalogProfessionsRepository::save)
                .map(mentorHasCatalogProfessionsReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public boolean delete(MentorHasCatalogProfessionsId id) {
        return mentorCatalogProfessionsRepository.findById(id)
                .map(mentor -> {
                    mentorCatalogProfessionsRepository.delete(mentor);
                    mentorCatalogProfessionsRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
