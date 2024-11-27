package com.nttdata.bootcamp_customer_service.repository;

import com.nttdata.bootcamp_customer_service.model.collection.BankProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankProductRepository extends MongoRepository<BankProduct, String> {
    // Métodos personalizados, como buscar productos por cliente
    List<BankProduct> findByCustomerId(String customerId);

    // También podemos buscar por número de producto si lo necesitamos
    BankProduct findByProductNumber(String productNumber);
}