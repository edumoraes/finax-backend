package com.finax.api.controllers;

import com.finax.api.domain.bill.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/bills")
@SecurityRequirement(name = "bearer-key")
public class BillController {

    @Autowired
    private BillService service;

    @PostMapping("/to-pay")
    @Transactional
    public ResponseEntity registerBillToPay(@RequestBody @Valid BillToPayRegistrationDTO data, UriComponentsBuilder uriComponentsBuilder) {
        var newBillToPay = service.registerBillToPay(data);
        var uri = uriComponentsBuilder.path("/bills/to-pay/{id}")
                .buildAndExpand(newBillToPay.getId()).toUri();
        return ResponseEntity.created(uri).body(new BillToPayDatailDTO(newBillToPay));
    }

    @GetMapping("/to-pay/{id}")
    public ResponseEntity detailBillToPay(@PathVariable("id") Long id) {
        var billToPay = service.detailBillToPay(id);
        return ResponseEntity.ok(new BillToPayDatailDTO(billToPay));
    }

    @PostMapping("/to-receive")
    @Transactional
    public ResponseEntity registerBillToReceive(@RequestBody @Valid BillToReceiveRegistrationDTO data, UriComponentsBuilder uriComponentsBuilder) {
        var newBillToReceive = service.registerBillToReceive(data);
        var uri = uriComponentsBuilder.path("/bills/to-receive/{id}")
                .buildAndExpand(newBillToReceive.getId()).toUri();
        return ResponseEntity.created(uri).body(new BillToReceiveDetailDTO(newBillToReceive));
    }

    @GetMapping("/to-receive/{id}")
    public ResponseEntity detailBillToReceive(@PathVariable("id") Long id) {
        var billToReceive = service.detailBillToReceive(id);
        return ResponseEntity.ok(new BillToReceiveDetailDTO(billToReceive));
    }
}
