package com.finax.api.controllers;

import com.finax.api.domain.organization.AccountOrganizationDetailDTO;
import com.finax.api.domain.organization.AccountOrganizationRegistrationDTO;
import com.finax.api.domain.organization.AccountOrganizationService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/account-organizations")
public class AccountOrganizationController {

    @Autowired
    private AccountOrganizationService service;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid AccountOrganizationRegistrationDTO data, UriComponentsBuilder uriComponentsBuilder) {
        var newAccountOrganization = service.registerAccountOrganization(data);
        var uri = uriComponentsBuilder.path("/account-organizations/{id}").buildAndExpand(newAccountOrganization.getId()).toUri();
        return ResponseEntity.created(uri).body(new AccountOrganizationDetailDTO(newAccountOrganization));
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable("id") Long id) {
        var accountOrganization = service.detail(id);
        return ResponseEntity.ok(new AccountOrganizationDetailDTO(accountOrganization));
    }
}
