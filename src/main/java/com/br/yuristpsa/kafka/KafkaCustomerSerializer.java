package com.br.yuristpsa.kafka;

import com.br.yuristpsa.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

@Slf4j
public class KafkaCustomerSerializer implements Serializer<Customer> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @SneakyThrows
    @Override
    public byte[] serialize(String topic, Customer data) {
        return objectMapper.writeValueAsBytes(data);
    }

    @Override
    public void close() {
    }
}