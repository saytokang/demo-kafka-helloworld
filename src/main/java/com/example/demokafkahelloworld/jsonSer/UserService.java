package com.example.demokafkahelloworld.jsonSer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserService {
    private final KafkaTemplate<String, User> kafkaTemplate;

    public void createUser(User user) {
        kafkaTemplate.send(KafkaConfigOnUser.TOPIC_NAME, user.getId()+"", user);
    }
}
