package com.example.demokafkahelloworld.jsonSer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserService {
    private final KafkaTemplate<String, User> kafkaTemplate;

    public void createUser(User user) {
        kafkaTemplate
            .send(KafkaConfigOnUser.TOPIC_NAME, user.getId()+"", user)
            .thenAccept(rs -> log.info(" send OK. offset: {}", rs.getRecordMetadata().offset()))
            .exceptionally(ex -> {
                log.error("{}", ex);
                return null;
            });
    }
}
