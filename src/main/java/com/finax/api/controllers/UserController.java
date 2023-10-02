package com.finax.api.controllers;

import com.finax.api.domain.user.UserDetailDTO;
import com.finax.api.domain.user.UserRegistrationDTO;
import com.finax.api.services.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid UserRegistrationDTO user, UriComponentsBuilder uriComponentsBuilder) {
        var newUser = service.create(user);
        var uri = uriComponentsBuilder.path("/users/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDetailDTO(newUser));
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable String id) {
        var user = service.detail(id);
        return ResponseEntity.ok(new UserDetailDTO(user));
    }
}
