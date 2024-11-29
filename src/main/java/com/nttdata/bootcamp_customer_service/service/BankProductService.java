package com.nttdata.bootcamp_customer_service.service;

import com.nttdata.bootcamp_customer_service.model.collection.BankProduct;
import com.nttdata.bootcamp_customer_service.model.dto.Transaction;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.List;

public interface BankProductService {
    Mono<ResponseEntity<BankProduct>> createBankProduct(BankProduct bankProduct);

    Flux<ResponseEntity<BankProduct>> getAllBankProducts();

    Mono<ResponseEntity<BankProduct>> getBankProductById(String productId);

    Mono<ResponseEntity<BankProduct>> updateBankProduct(String productId, BankProduct bankProduct);

    Mono<ResponseEntity<Object>> deleteBankProduct(String productId);

    Mono<ResponseEntity<BigDecimal>> getProductBalance(String productId);

    Mono<ResponseEntity<List<Transaction>>> getProductTransactions(String productId);

    Mono<ResponseEntity<BankProduct>> makeTransaction(String productId, Transaction transaction);
}
