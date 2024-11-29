package com.nttdata.bootcamp_product_type_service.service.impl;

import com.nttdata.bootcamp_product_type_service.model.collection.ProductType;
import com.nttdata.bootcamp_product_type_service.repository.ProductTypeRepository;
import com.nttdata.bootcamp_product_type_service.service.ProductTypeService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    private final ProductTypeRepository productTypeRepository;

    public ProductTypeServiceImpl(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    @Override
    public Mono<ProductType> createProductType(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    @Override
    public Flux<ProductType> getAllProductTypes() {
        return productTypeRepository.findAll();
    }

    @Override
    public Mono<ProductType> getProductTypeById(String id) {
        return productTypeRepository.findById(id);
    }

    @Override
    public Mono<ProductType> updateProductType(ProductType productType) {
        return productTypeRepository.findById(productType.getId())
                .flatMap(existingProductType -> {
                    existingProductType.setName(productType.getName());
                    existingProductType.setType(productType.getType());
                    existingProductType.setCommission(productType.getCommission());
                    existingProductType.setTransactionCount(productType.getTransactionCount());
                    return productTypeRepository.save(existingProductType);
                });
    }

    @Override
    public Mono<Void> deleteProductType(String id) {
        return productTypeRepository.findById(id)
                .flatMap(productTypeRepository::delete);
    }
}

