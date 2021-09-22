package com.br.yuristpsa.config;

import org.eclipse.microprofile.config.inject.ConfigProperties;

//@ConfigProperties(prefix = "kafka")
public class BaseKafkaConfiguration {

    private KafkaConfiguration invalidationConfig;

    private String bootstrapServers;
    private String keySerializer;
    private String valueSerializer;

    public static class KafkaConfiguration {
        private String topic;

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }
    }

    public KafkaConfiguration getInvalidationConfig() {
        return invalidationConfig;
    }

    public void setInvalidationConfig(KafkaConfiguration invalidationConfig) {
        this.invalidationConfig = invalidationConfig;
    }

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public String getKeySerializer() {
        return keySerializer;
    }

    public void setKeySerializer(String keySerializer) {
        this.keySerializer = keySerializer;
    }

    public String getValueSerializer() {
        return valueSerializer;
    }

    public void setValueSerializer(String valueSerializer) {
        this.valueSerializer = valueSerializer;
    }
}
