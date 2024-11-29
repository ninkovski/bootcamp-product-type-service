package com.nttdata.bootcamp_customer_service.controller;

import com.nttdata.bootcamp_customer_service.model.collection.ProductType;
import com.nttdata.bootcamp_customer_service.service.ProductTypeService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/product-types")
public class ProductTypeController {
    private final ProductTypeService productTypeService;

    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @PostMapping
    public Mono<ProductType> createProductType(@RequestBody ProductType productType) {
        return productTypeService.createProductType(productType);
    }

    @GetMapping
    public Flux<ProductType> getAllProductTypes() {
        return productTypeService.getAllProductTypes();
    }

    @GetMapping("/{id}")
    public Mono<ProductType> getProductTypeById(@PathVariable String id) {
        return productTypeService.getProductTypeById(id);
    }

    @PutMapping
    public Mono<ProductType> updateProductType(@RequestBody ProductType productType) {
        return productTypeService.updateProductType(productType);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProductType(@PathVariable String id) {
        return productTypeService.deleteProductType(id);
    }
}
