package com.nttdata.bootcamp_customer_service.model.dto;

import lombok.Data;

@Data
public class Transaction {
    private String productId;  // Reference to the bank product (account)
    private boolean isSubtract;  // Transaction amount (positive for deposits, negative for withdrawals)
    private double amount;  // Transaction amount (positive for deposits, negative for withdrawals)
    private String date;  // Transaction date (ISO format or String)
}
