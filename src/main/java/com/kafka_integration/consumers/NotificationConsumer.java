package com.kafka_integration.consumers;

import com.kafka_integration.dto.Notification;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @KafkaListener(topics = "notifications" , groupId = "notification_listner")
    public void listenNotifications(Notification notification){
        System.out.println("Sending notification to user: " + notification.getUserId());
    }

}
