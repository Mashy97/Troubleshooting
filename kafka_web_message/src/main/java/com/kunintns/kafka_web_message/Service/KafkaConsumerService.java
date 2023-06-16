package com.kunintns.kafka_web_message.Service;

import com.kunintns.kafka_web_message.Vo.MessageVO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "input100-topic", groupId = "topic", containerFactory = "kafkaListener")
    public void consumeRecord(MessageVO message){
        System.out.println("ID = " + message.getId());
        System.out.println("position = " + message.getPosition());
        System.out.println("longitude = " + message.getLongitude());
        System.out.println("latitude = " + message.getLatitude());
        System.out.println("latitude = " + message.getTime());
    }
}

