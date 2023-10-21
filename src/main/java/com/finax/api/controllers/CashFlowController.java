package com.finax.api.controllers;

import com.finax.api.domain.bill.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cash-flow")
@SecurityRequirement(name = "bearer-key")
public class CashFlowController {

    @Autowired
    private CashFlow cashFlow;

    @PutMapping("/pay")
    @Transactional
    public ResponseEntity pay(@RequestBody @Valid BillPaymentDTO data) {
        BillToPay billPayed = cashFlow.payBill(data);
        return ResponseEntity.ok(new BillToPayDatailDTO(billPayed));
    }

    @PutMapping("/receive")
    @Transactional
    public ResponseEntity receive(@RequestBody @Valid BillReceivedDTO data) {
        BillToReceive billToReceived = cashFlow.receiveBill(data);
        return ResponseEntity.ok(new BillToReceiveDetailDTO(billToReceived));
    }
}
