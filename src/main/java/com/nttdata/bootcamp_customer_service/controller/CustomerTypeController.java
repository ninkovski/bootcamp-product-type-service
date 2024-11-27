package com.nttdata.bootcamp_customer_service.controller;

import com.nttdata.bootcamp_customer_service.config.CustomerTypeConfig;
import com.nttdata.bootcamp_customer_service.model.CustomerType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customer-types")
public class CustomerTypeController {

    final CustomerTypeConfig customerTypeConfig;

    public CustomerTypeController(CustomerTypeConfig customerTypeConfig) {
        this.customerTypeConfig = customerTypeConfig;
    }

    @GetMapping("/config")
    public List<CustomerType> getCustomerTypes() {
        return new ArrayList<>(customerTypeConfig.getType().values());
    }
}