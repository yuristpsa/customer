package com.br.yuristpsa;

import com.br.yuristpsa.model.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

//com.br.yuristpsa.KafkaValueSerializer

@Slf4j
public class KafkaValueSerializer implements Serializer<Customer> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, Customer data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            log.error("Unable to serialize object {}", data, e);
            return null;
        }
    }

    @Override
    public void close() {
    }
}