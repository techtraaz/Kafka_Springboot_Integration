package com.kafka_integration.consumers;

import com.kafka_integration.dto.Orders;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @KafkaListener(topics = "orders" , groupId = "order_listner")
    public void listenOrder(Orders order){
        System.out.println("Processing order: " + order.getOrderId() + " for product " + order.getProduct());
    }

}
