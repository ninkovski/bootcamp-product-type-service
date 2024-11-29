package com.nttdata.bootcamp_customer_service.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response<T> {
    private String message;
    private T data;
}
