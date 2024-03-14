package onlineretailer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
@Profile("with-kafka")
public class ProductSuggestionTopicListener {

    @KafkaListener(topics = "product_suggestions_topic", groupId="group1")
    public void listener(
            @Header(KafkaHeaders.RECEIVED_KEY) String key,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            String value) {

        System.out.printf("********** Message received from topic %s, key: %s, value: %s\n", topic, key, value);
    }
}
