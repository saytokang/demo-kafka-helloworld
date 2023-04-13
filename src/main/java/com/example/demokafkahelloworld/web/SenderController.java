package com.example.demokafkahelloworld.web;

import java.time.LocalTime;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class SenderController {

	private final KafkaTemplate kafkaTemplate;

	@PostMapping("/send")
	public ResponseEntity<?> send(@RequestBody String data) {
		String message = String.format("sent time: %s\n%s", LocalTime.now(), data);
		kafkaTemplate.send("mytopic", data);
		log.info("send to kafka.");
		return ResponseEntity.ok().build();
	}

}
