package org.tinkoff.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.tinkoff.dto.user.UserCreateEditDto;
import org.tinkoff.dto.user.UserReadDto;
import org.tinkoff.service.UserService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@SecurityRequirement(name = "Keycloak")
public class UserController {
    private final UserService userService;
    @GetMapping("")
    @PreAuthorize("hasRole('admin')")
    public List<UserReadDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('admin')")
    public Optional<UserReadDto> findById(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    @PostMapping("")
    @PreAuthorize("hasRole('admin')")
    @ResponseStatus(HttpStatus.CREATED)
    public UserReadDto create(UserCreateEditDto user) {
        return userService.create(user);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('admin')")
    public UserReadDto update(@PathVariable("id") Integer id,
                              UserCreateEditDto userCreateEditDto){
        return userService
                .update(id, userCreateEditDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('admin')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        if (!userService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


}
