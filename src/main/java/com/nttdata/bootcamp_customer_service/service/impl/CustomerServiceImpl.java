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
        return customerRepository.findAll();
    }

    @Override
    public Mono<Customer> getCustomerById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public Mono<Customer> createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Mono<Customer> updateCustomer(String id, Customer customer) {
        return customerRepository.findById(id)
                .flatMap(existingCustomer -> {
                    existingCustomer.setName(customer.getName());
                    existingCustomer.setDocumentNumber(customer.getDocumentNumber());
                    existingCustomer.setCustomerType(customer.getCustomerType());
                    existingCustomer.setEmail(customer.getEmail());
                    existingCustomer.setPhoneNumber(customer.getPhoneNumber());
                    return customerRepository.save(existingCustomer);
                });
    }

    @Override
    public Mono<Void> deleteCustomer(String id) {
        return customerRepository.deleteById(id);
    }
}
