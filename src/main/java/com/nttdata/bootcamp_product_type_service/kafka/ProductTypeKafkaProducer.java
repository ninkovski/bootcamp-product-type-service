package com.nttdata.bootcamp_product_type_service.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.bootcamp_product_type_service.model.collection.ProductType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductTypeKafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProductTypeKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendProductTypeResponse(ProductType productType) {
        try {
            String message = serializeProductType(productType);
            kafkaTemplate.send("product-type-response", message);
            log.info("Producto enviado a Kafka: {}", message);
        } catch (Exception e) {
            log.error("Error enviando producto a Kafka: {}", e.getMessage());
        }
    }

    private String serializeProductType(ProductType productType) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(productType);
        } catch (Exception e) {
             log.error("no se pudo serializar el producto para enviar a la cola, {}", e.getMessage());
            return "{}";
        }
    }
}

