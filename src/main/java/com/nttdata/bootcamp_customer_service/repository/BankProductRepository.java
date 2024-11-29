package com.nttdata.bootcamp_customer_service.repository;

import com.nttdata.bootcamp_customer_service.model.collection.BankProduct;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface BankProductRepository extends ReactiveMongoRepository<BankProduct, String> {
    // buscar por número de producto si lo necesitamos
    BankProduct findByProductNumber(String productNumber);

    Flux<BankProduct> findAllByCustomerId(String customerId);
}