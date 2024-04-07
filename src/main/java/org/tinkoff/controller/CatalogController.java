package org.tinkoff.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.tinkoff.dto.catalog.CatalogProfessionsCreateEditDto;
import org.tinkoff.dto.catalog.CatalogProfessionsReadDto;
import org.tinkoff.service.CatalogProfessionsService;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/catalog")
@RequiredArgsConstructor
@SecurityRequirement(name = "Keycloak")
public class CatalogController {
    private final CatalogProfessionsService catalogProfessionsService;
    @GetMapping("")
    @PreAuthorize("hasRole('admin')")
    public List<CatalogProfessionsReadDto> findAll() {
        return catalogProfessionsService.findAll();
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('admin')")
    public Optional<CatalogProfessionsReadDto> findById(@PathVariable("id") Integer id) {
        return catalogProfessionsService.findById(id);
    }

    @GetMapping("/catalog/by_name")
    @PreAuthorize("hasRole('admin')")
    public Optional<CatalogProfessionsReadDto> findByName(@RequestParam("name") String name) {
        return catalogProfessionsService.findByName(name);
    }

    @PostMapping("")
    @PreAuthorize("hasRole('admin')")
    @ResponseStatus(HttpStatus.CREATED)
    public CatalogProfessionsReadDto create(@Valid CatalogProfessionsCreateEditDto catalog, BindingResult bindingResult) {
        return catalogProfessionsService.create(catalog);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('admin')")
    public CatalogProfessionsReadDto update(@PathVariable("id") Integer id,
                                @Valid CatalogProfessionsCreateEditDto mentor, BindingResult bindingResult){
        return catalogProfessionsService
                .update(id, mentor)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('admin')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        if (!catalogProfessionsService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
