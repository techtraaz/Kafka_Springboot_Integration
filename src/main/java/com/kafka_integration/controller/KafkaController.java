package com.kafka_integration.controller;

import com.kafka_integration.dto.Notification;
import com.kafka_integration.dto.Orders;
import com.kafka_integration.producers.NotificationProducer;
import com.kafka_integration.producers.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final OrderProducer orderProducer;
    private final NotificationProducer notificationProducer;

    @PostMapping("/order/create")
    public ResponseEntity<String> createOrder(@RequestBody Orders order){
        System.out.println("----- Request received -----");
        orderProducer.sendOrder(order);
        return ResponseEntity.ok("Order created");
    }

    @PostMapping("/notifications")
    public ResponseEntity<String> publishNotification(@RequestBody Notification notification) {
        System.out.println("----- Request received -----");
        notificationProducer.sendNotification(notification);
        return ResponseEntity.ok("Notification sent");
    }


}
