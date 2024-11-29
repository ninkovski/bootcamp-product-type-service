package com.nttdata.bootcamp_customer_service.repository;

import com.nttdata.bootcamp_customer_service.model.collection.BankProduct;
import com.nttdata.bootcamp_customer_service.model.collection.ProductType;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ProductTypeRepository extends ReactiveMongoRepository<ProductType, String> {
    @Query("{ 'accountHolders.customerId': ?0 }")
    Flux<BankProduct> findAllByCustomerId(String customerId);
}
