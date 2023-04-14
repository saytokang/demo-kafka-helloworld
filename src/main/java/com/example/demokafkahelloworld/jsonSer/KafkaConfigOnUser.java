package com.example.demokafkahelloworld.jsonSer;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class KafkaConfigOnUser {
    
    public static final String TOPIC_NAME = "jsonSer";
    @Bean
    public NewTopic jsonSerTopic() {
        return TopicBuilder.name(TOPIC_NAME).partitions(1).replicas(1).build();
    }

    @KafkaListener(topics = TOPIC_NAME)
    public void onMessage(ConsumerRecord<String, User> records) {
        log.info("[수신] key:message --> {}: {}", records.key(), records.value());
    }
    
}
