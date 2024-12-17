package com.nttdata.bootcamp_product_type_service.kafka;

import com.nttdata.bootcamp_product_type_service.service.ProductTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductTypeRequestConsumer {

    private final ProductTypeService productTypeService;
    private final ProductTypeKafkaProducer kafkaProducer;

    public ProductTypeRequestConsumer(ProductTypeService productTypeService, ProductTypeKafkaProducer kafkaProducer) {
        this.productTypeService = productTypeService;
        this.kafkaProducer = kafkaProducer;
    }

    @KafkaListener(topics = "product-type-request", groupId = "product-type-service-group")
    public void listenForProductTypeRequest(String productId) {
        log.info("Solicitud recibida para el ID: {}", productId);

        productTypeService.getProductTypeById(productId)
                .subscribe(productType -> {
                    System.out.println("Producto encontrado: " + productType);
                    kafkaProducer.sendProductTypeResponse(productType);
                }, error -> {
                    log.error("Error al obtener el tipo de producto con ID: {}", productId, error);
                });
    }
}
