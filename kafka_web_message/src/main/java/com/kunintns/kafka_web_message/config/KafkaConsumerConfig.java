package com.kunintns.kafka_web_message.config;

import com.kunintns.kafka_web_message.Vo.MessageVO;
import jakarta.annotation.PostConstruct;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String servers;
    private ConsumerFactory<String, MessageVO> consumerFactory;

    @PostConstruct
    private void initializeConsumerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "topic");
        consumerFactory = new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), new JsonDeserializer<>(MessageVO.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, MessageVO> kafkaListener() {
        ConcurrentKafkaListenerContainerFactory<String, MessageVO> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }
}