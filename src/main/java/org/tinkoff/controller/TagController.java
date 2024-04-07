package org.tinkoff.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.tinkoff.dto.tag.TagCreateEditDto;
import org.tinkoff.dto.tag.TagReadDto;
import org.tinkoff.service.TagService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/tag")
@RequiredArgsConstructor
@SecurityRequirement(name = "Keycloak")
public class TagController {
    private final TagService tagService;
    @GetMapping("")
    @PreAuthorize("hasRole('admin')")
    public List<TagReadDto> findAll() {
        return tagService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('admin')")
    public Optional<TagReadDto> findById(@PathVariable("id") Integer id) {
        return tagService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('admin')")
    public TagReadDto create(TagCreateEditDto tagCreateEditDto) {
        return tagService.create(tagCreateEditDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('admin')")
    public TagReadDto update(@PathVariable("id") Integer id,
                             TagCreateEditDto tagCreateEditDto){
        return tagService
                .update(id, tagCreateEditDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('admin')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        if (!tagService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
