package com.kafka_integration.producers;

import com.kafka_integration.dto.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationProducer {

    private final KafkaTemplate<String, Notification> kafkaTemplate;

    public void sendNotification(Notification notification){
        kafkaTemplate.send("notifications" , notification.getUserId() , notification);
    }

}
