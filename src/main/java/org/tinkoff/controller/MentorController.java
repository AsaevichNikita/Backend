package org.tinkoff.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.tinkoff.dto.mentor.MentorCreateEditDto;
import org.tinkoff.dto.mentor.MentorReadDto;
import org.tinkoff.service.MentorService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/mentor")
@RequiredArgsConstructor
@SecurityRequirement(name = "Keycloak")
public class MentorController {
    private final MentorService mentorService;
    @GetMapping("")
    @PreAuthorize("hasRole('admin')")
    public List<MentorReadDto> findAll() {
        return mentorService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('admin')")
    public Optional<MentorReadDto> findById(@PathVariable("id") Integer id) {
        return mentorService.findById(id);
    }

    @PostMapping("")
    @PreAuthorize("hasRole('admin')")
    @ResponseStatus(HttpStatus.CREATED)
    public MentorReadDto create(MentorCreateEditDto mentor) {
        return mentorService.create(mentor);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('admin')")
    public MentorReadDto update(@PathVariable("id") Integer id,
                                @RequestBody MentorCreateEditDto mentorCreateEditDto){
        return mentorService
                .update(id, mentorCreateEditDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('admin')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        if (!mentorService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
