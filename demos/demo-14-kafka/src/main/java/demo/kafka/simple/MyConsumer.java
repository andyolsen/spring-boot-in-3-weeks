package demo.kafka.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class MyConsumer {

    private static final Logger logger = LoggerFactory.getLogger(MyConsumer.class);

    @KafkaListener(topics = "mytopic", groupId="group1")
    public void group1ConsumerA(
            @Header(KafkaHeaders.RECEIVED_KEY) String key,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_TIMESTAMP) String timestamp,
            String value){
        logger.info(String.format("********** MyConsumer group1ConsumerA consumed message: key %s, topic %s, timestamp %s, value %s", key, topic, timestamp, value));
    }

    @KafkaListener(topics = "mytopic", groupId="group1")
    public void group1ConsumerB(
            @Header(KafkaHeaders.RECEIVED_KEY) String key,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_TIMESTAMP) String timestamp,
            String value) {
        logger.info(String.format("********** MyConsumer group1ConsumerB consumed message: key %s, topic %s, timestamp %s, value %s", key, topic, timestamp, value));
    }

    @KafkaListener(topics = "mytopic", groupId="group2")
    public void group2ConsumerA(
            @Header(KafkaHeaders.RECEIVED_KEY) String key,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_TIMESTAMP) String timestamp,
            String value) {
        logger.info(String.format("********** MyConsumer group2ConsumerA consumed message: key %s, topic %s, timestamp %s, value %s", key, topic, timestamp, value));
    }

    @KafkaListener(topics = "mytopic", groupId="group2")
    public void group2ConsumerB(
            @Header(KafkaHeaders.RECEIVED_KEY) String key,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_TIMESTAMP) String timestamp,
            String value) {
        logger.info(String.format("********** MyConsumer group2ConsumerB consumed message: key %s, topic %s, timestamp %s, value %s", key, topic, timestamp, value));
    }
}