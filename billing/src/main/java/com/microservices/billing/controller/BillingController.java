package com.microservices.billing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/billing/")
public class BillingController {

    @GetMapping(path = "allBills")
    public void getAllBills(){

    }
}
