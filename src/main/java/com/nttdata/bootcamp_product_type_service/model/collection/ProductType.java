package com.nttdata.bootcamp_product_type_service.model.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "product_types")
@Data
public class ProductType {
    @Id
    private String id; // Unique ID of the product type
    private String name; // Name of the product type
    private BigDecimal amount;
    private String type; // Type of product
    private BigDecimal commission; // Commission fee associated with this product type
    private Integer transactionCount; // Number of transactions
    private BigDecimal interest;
    private String period;
}