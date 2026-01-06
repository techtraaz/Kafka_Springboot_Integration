package com.kafka_integration.dto;

import lombok.Data;

@Data
public class Orders {

    private String orderId;
    private String product;
    private int quantity;

}
