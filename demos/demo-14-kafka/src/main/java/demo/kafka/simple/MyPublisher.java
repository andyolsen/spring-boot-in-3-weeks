package demo.kafka.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyPublisher {

    private static final Logger logger = LoggerFactory.getLogger(MyPublisher.class);
    private static final String TOPIC_NAME = "mytopic";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String key, String value){
        logger.info(String.format("********** MyPublisher is sending message: %s:%s", key, value));
        this.kafkaTemplate.send(TOPIC_NAME, key, value);
    }
}
