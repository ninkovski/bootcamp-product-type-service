package com.nttdata.bootcamp_customer_service.service.impl;

import com.nttdata.bootcamp_customer_service.model.Customer;
import com.nttdata.bootcamp_customer_service.repository.CustomerRepository;
import com.nttdata.bootcamp_customer_service.service.CustomerService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Flux<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public Mono<Customer> getCustomerById(String id) {
        return null;
    }

    @Override
    public Mono<Customer> createCustomer(Customer customer) {
        return null;
    }

    @Override
    public Mono<Customer> updateCustomer(String id, Customer customer) {
        return null;
    }

    @Override
    public Mono<Void> deleteCustomer(String id) {
        return null;
    }
}
