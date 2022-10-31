package com.uni.pnu.controller;

import com.uni.pnu.entity.OrderDetails;
import com.uni.pnu.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = {"/createPaymentOrder/{amount}"})
    public OrderDetails createOrder(@PathVariable(name = "amount") Double amount) {
        return paymentService.createOrder(amount);
    }
}
