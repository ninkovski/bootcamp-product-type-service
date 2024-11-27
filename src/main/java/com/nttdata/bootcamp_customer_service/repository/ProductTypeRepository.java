package com.nttdata.bootcamp_customer_service.repository;

import com.nttdata.bootcamp_customer_service.model.collection.ProductType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductTypeRepository extends MongoRepository<ProductType, String> {
    ProductType findByName(String name);
}
