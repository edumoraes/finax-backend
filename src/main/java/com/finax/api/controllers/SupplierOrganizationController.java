package com.finax.api.controllers;

import com.finax.api.domain.organization.SupplierOrganizationDetailDTO;
import com.finax.api.domain.organization.SupplierOrganizationRegistrationDTO;
import com.finax.api.domain.organization.SupplierOrganizationService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/supplier-organizations")
@SecurityRequirement(name = "bearer-key")
public class SupplierOrganizationController {

    @Autowired
    private SupplierOrganizationService supplierOrganizationService;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid SupplierOrganizationRegistrationDTO data, UriComponentsBuilder uriComponentsBuilder){
        var supplierOraganization = supplierOrganizationService.registerSupplierOrganization(data);
        var uri = uriComponentsBuilder.path("/supplier-organizations/{id}")
                .buildAndExpand(supplierOraganization.getId()).toUri();
        return ResponseEntity.created(uri).body(new SupplierOrganizationDetailDTO(supplierOraganization));
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable("id") Long id) {
        var supplierOrganization = supplierOrganizationService.detail(id);
        return ResponseEntity.ok(new SupplierOrganizationDetailDTO(supplierOrganization));
    }
}
