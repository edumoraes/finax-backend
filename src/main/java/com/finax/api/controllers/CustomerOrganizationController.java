package com.finax.api.controllers;

import com.finax.api.domain.organization.CustomerOrganizationDetailDTO;
import com.finax.api.domain.organization.CustomerOrganizationRegistrationDTO;
import com.finax.api.domain.organization.CustomerOrganizationService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/customer-organizations")
@SecurityRequirement(name = "bearer-key")
public class CustomerOrganizationController {

    @Autowired
    private CustomerOrganizationService customerOrganizationService;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid CustomerOrganizationRegistrationDTO data, UriComponentsBuilder uriComponentsBuilder){
        var customerOraganization = customerOrganizationService.registerCustomerOrganization(data);
        var uri = uriComponentsBuilder.path("/customer-organizations/{id}")
                .buildAndExpand(customerOraganization.getId()).toUri();
        return ResponseEntity.created(uri).body(new CustomerOrganizationDetailDTO(customerOraganization));
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable("id") Long id) {
        var customerOrganization = customerOrganizationService.detail(id);
        return ResponseEntity.ok(new CustomerOrganizationDetailDTO(customerOrganization));
    }
}
