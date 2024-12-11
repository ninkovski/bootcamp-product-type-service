package com.nttdata.bootcamp_product_type_service.service.impl;

import com.nttdata.bootcamp_product_type_service.model.collection.ProductType;
import com.nttdata.bootcamp_product_type_service.repository.ProductTypeRepository;
import com.nttdata.bootcamp_product_type_service.service.ProductTypeService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    private final ProductTypeRepository productTypeRepository;

    public ProductTypeServiceImpl(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    @Override
    public Mono<ProductType> createProductType(ProductType productType) {
        if (productType.getAmount() == null) {
            productType.setAmount(BigDecimal.ZERO);
        } else if (productType.getAmount().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo");
        } else {
            productType.setAmount(productType.getAmount().setScale(2, RoundingMode.HALF_UP));
        }

        if (productType.getCommission() == null) {
            productType.setCommission(BigDecimal.ZERO);
        } else if (productType.getCommission().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("La comisión no puede ser negativa");
        } else {
            productType.setCommission(productType.getCommission().setScale(2, RoundingMode.HALF_UP));
        }

        if (productType.getTransactionCount() == null) {
            productType.setTransactionCount(0);
        } else if (productType.getTransactionCount() < 0) {
            throw new IllegalArgumentException("El conteo de transacciones no puede ser negativo");
        }

        if (productType.getInterest() == null) {
            productType.setInterest(BigDecimal.ZERO);
        } else if (productType.getInterest().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El interés no puede ser negativo");
        } else {
            productType.setInterest(productType.getInterest().setScale(2, RoundingMode.HALF_UP));
        }
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
                    existingProductType.setInterest(productType.getInterest());
                    existingProductType.setPeriod(productType.getPeriod());
                    existingProductType.setAmount(productType.getAmount());
                    return productTypeRepository.save(existingProductType);
                });
    }

    @Override
    public Mono<Void> deleteProductType(String id) {
        return productTypeRepository.findById(id)
                .flatMap(productTypeRepository::delete);
    }
}

