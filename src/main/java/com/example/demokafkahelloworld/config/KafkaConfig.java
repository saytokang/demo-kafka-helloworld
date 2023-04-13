package com.example.demokafkahelloworld.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class KafkaConfig {

	@Bean
	public NewTopic topic() {
		// @formatter:off
        return TopicBuilder
            .name("mytopic")
            .partitions(1)
            .replicas(1)
            .build();
        // @formatter:on		
	}

	@KafkaListener(id = "consumer-1", topics = "mytopic")
	public void listen(String data) {
		log.info("==> [수신] : {}", data);
	}

}
