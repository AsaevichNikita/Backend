package org.tinkoff.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.tinkoff.database.entity.MentorHasCatalogProfessionsId;
import org.tinkoff.dto.mentor_catalog.MentorCatalogProfessionsCreateEditDto;
import org.tinkoff.dto.mentor_catalog.MentorHasCatalogProfessionsReadDto;
import org.tinkoff.service.MentorCatalogProfessionsService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/user/mentor/catalog")
@RequiredArgsConstructor
@SecurityRequirement(name = "Keycloak")
public class MentorCatalogController {
    private final MentorCatalogProfessionsService mentorCatalogProfessionsService;
    @GetMapping("")
    @PreAuthorize("hasRole('admin')")
    public List<MentorHasCatalogProfessionsReadDto> findAll() {
        return mentorCatalogProfessionsService.findAll();
    }

    @GetMapping("/{mentorId}/{catalogId}")
    @PreAuthorize("hasRole('admin')")
    public Optional<MentorHasCatalogProfessionsReadDto> findById(
            @PathVariable("mentorId") Integer mentorId,
            @PathVariable("catalogId") Integer catalogId) {

        return mentorCatalogProfessionsService
                .findById(new MentorHasCatalogProfessionsId(
                    mentorId,
                    catalogId
                )
        );
    }

    @PostMapping("")
    @PreAuthorize("hasRole('admin')")
    @ResponseStatus(HttpStatus.CREATED)
    public MentorHasCatalogProfessionsReadDto create(MentorCatalogProfessionsCreateEditDto mentorCatalog) {
        return mentorCatalogProfessionsService.create(mentorCatalog);
    }

    @DeleteMapping("/{mentorId}/{catalogId}")
    @PreAuthorize("hasRole('admin')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable("mentorId") Integer mentorId,
                        @PathVariable("catalogId") Integer catalogId) {
        if (!mentorCatalogProfessionsService.delete
                (new MentorHasCatalogProfessionsId(mentorId, catalogId))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
