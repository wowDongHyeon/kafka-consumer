package com.example.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.LogMessageRepository;

@Service
public class KafkaConsumerService {

    @Autowired
    private LogMessageRepository logMessageRepository;

    @KafkaListener(topics = "test-topic", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
        
        // LogMessage 객체 생성
        LogMessage logMessage = new LogMessage("your_topic_name", message, "consumer");
        
        // MongoDB에 로그 메시지 저장
        logMessageRepository.save(logMessage);
    }
} 