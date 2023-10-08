package com.finax.api.domain.bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashFlow {

    @Autowired
    private BillService billService;

    public BillToPay payBill(BillPaymentDTO bill) {
        BillToPay billToPay = billService.detailBillToPay(bill.id());
        billToPay.pay(bill);

        return billToPay;
    }

    public BillToReceive receiveBill(BillReceivedDTO bill) {
        BillToReceive billToReceive = billService.detailBillToReceive(bill.id());
        billToReceive.receive(bill);

        return billToReceive;
    }

}
