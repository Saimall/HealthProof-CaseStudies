package com.example.producer;

import com.example.producer.models.Record;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import  com.example.producer.services.DataService;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@EnableScheduling
public class ProducerApplication {

	private static final Logger logger = LoggerFactory.getLogger(ProducerApplication.class);



		@Autowired
		private DataService dataService;

		@Autowired
		private JmsTemplate jmsTemplate;







		@Scheduled(fixedRate = 10000) // Fetch data every 5 seconds
		public void fetchDataAndSendToQueue() {
			List<Record> records = dataService.fetchData();
			ObjectMapper objectMapper = new ObjectMapper();
			records.forEach(record -> {
				try {
					String recordJson = objectMapper.writeValueAsString(record);
					jmsTemplate.convertAndSend("myQueue", recordJson);
				   logger.info("Data converted and sent to Queue");
				} catch (JsonProcessingException e) {

					logger.info("Error while converting data and sending to queue");
				  logger.error(String.valueOf(e));
				}
			});
		}


		public static void main(String[] args) {
			SpringApplication.run(ProducerApplication.class, args);
		}
	}


