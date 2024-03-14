package demo.kafka.customobjects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class MyObjectConsumer {

    private static final Logger logger = LoggerFactory.getLogger(MyObjectConsumer.class);

    @KafkaListener(topics = "topic-of-objects", groupId="group1")
    public void consumer(
            @Header(KafkaHeaders.RECEIVED_KEY) String key,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_TIMESTAMP) String timestamp,
            Object value){
        logger.info(String.format("********** MyObjectConsumer.consumer() consumed message: key %s, topic %s, timestamp %s, value %s", key, topic, timestamp, value));
    }
}