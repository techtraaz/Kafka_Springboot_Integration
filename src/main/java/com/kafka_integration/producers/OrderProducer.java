package com.kafka_integration.producers;


import com.kafka_integration.dto.Orders;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, Orders> kafkaTemplate;

    public void sendOrder(Orders order){
        kafkaTemplate.send("orders", order.getOrderId() , order);
    }


}
