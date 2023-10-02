package com.finax.api.controllers;

import com.finax.api.domain.organization.AccountOrganizationCreationDTO;
import com.finax.api.services.AccountOrganizationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/{owner_id}/account-organizations")
public class AccountOrganizationController {

    @Autowired
    private AccountOrganizationService service;

    @PostMapping
    public ResponseEntity create(@PathVariable("owner_id") String ownerId, @RequestBody @Valid AccountOrganizationCreationDTO data, UriComponentsBuilder uriComponentsBuilder) {
        var newAccountOrganization = service.create(ownerId, data);
        var uri = uriComponentsBuilder.path("/account-organizations/{id}").buildAndExpand(newAccountOrganization.getId()).toUri();
        return ResponseEntity.created(uri).body(new AccountOrganizationCreationDTO(newAccountOrganization));
    }
}
