package demo.kafka.customobjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyObjectPublisher {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    public void sendMessage(String key, Object value){
        this.kafkaTemplate.send("topic-of-objects", key, value);
    }
}
