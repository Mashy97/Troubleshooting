package com.kunintns.kafka_web_message.Controller;

import com.kunintns.kafka_web_message.Service.KafkaProducerService;
import com.kunintns.kafka_web_message.Vo.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaController {
    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public KafkaController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/message")
    public String sendMessageToKafka(@RequestBody MessageVO message){
        kafkaProducerService.sendMessage(message);
        return "success";
    }
}
