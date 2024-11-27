package com.nttdata.bootcamp_customer_service.repository;

import com.nttdata.bootcamp_customer_service.model.collection.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
    Mono<Customer> findByDocumentNumber(String documentNumber);
}