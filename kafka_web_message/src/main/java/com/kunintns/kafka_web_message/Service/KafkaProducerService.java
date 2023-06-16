package com.kunintns.kafka_web_message.Service;


import com.kunintns.kafka_web_message.Vo.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, MessageVO> kafkaTemplate;
    private final String topic = "input100-topic";

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, MessageVO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(MessageVO message) {
        System.out.println("Producer: "+ message.getTime());
        kafkaTemplate.send(topic, message);
    }
}
