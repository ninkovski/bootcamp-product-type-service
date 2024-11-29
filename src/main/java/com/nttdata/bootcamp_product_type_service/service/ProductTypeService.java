package com.nttdata.bootcamp_product_type_service.service;

import com.nttdata.bootcamp_product_type_service.model.collection.ProductType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductTypeService {
    Mono<ProductType> createProductType(ProductType productType);

    Flux<ProductType> getAllProductTypes();

    Mono<ProductType> getProductTypeById(String id);

    Mono<ProductType> updateProductType(ProductType productType);

    Mono<Void> deleteProductType(String id);
}
