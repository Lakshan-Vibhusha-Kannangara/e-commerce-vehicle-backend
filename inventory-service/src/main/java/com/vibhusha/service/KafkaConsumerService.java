package com.vibhusha.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vibhusha.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumerService {
    @Autowired
    private MongoDBInventoryService service;

    private static final String TOPIC_NAME = "your-topic-name"; // Replace with the same topic name used in the producer

    @KafkaListener(topics = TOPIC_NAME, groupId = "your-group-id")
    public void consumeMessage(String message) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ProductDTO productDTO = objectMapper.readValue(message, ProductDTO.class);
            service.createProductDTO(productDTO);


        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}

