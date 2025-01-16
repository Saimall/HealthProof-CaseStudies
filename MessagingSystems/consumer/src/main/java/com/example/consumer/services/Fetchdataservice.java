package com.example.consumer.services;

import com.example.consumer.models.Record;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class Fetchdataservice {

    private static final Logger logger = LoggerFactory.getLogger(Fetchdataservice.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @JmsListener(destination = "myQueue")
    public void receiveMessage(String message) {
        try {

            Record record = objectMapper.readValue(message, Record.class);
            logger.info("Received message: {}", record);


            processRecord(record);

        } catch (JsonProcessingException e) {
            logger.error("Error while processing message: {}", e.getMessage());
        }
    }

    private void processRecord(Record record) {

        logger.info("Processing Record: ID={}, Data={}", record.getId(), record.getData());
    }
}
