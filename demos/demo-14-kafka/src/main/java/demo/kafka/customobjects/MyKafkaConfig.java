package demo.kafka.customobjects;

import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyKafkaConfig {

    // Create/configure a ProducerFactory bean that tells Kafka knows how to:
    // - serialize message keys into Strings
    // - serialize message values into JSON
    @Bean
    public ProducerFactory<String, Object> myProducerFactory() {

        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(props);
    }


    // Create a KafkaTemplate bean that uses the ProducerFactory we created above.
    // Our client code will autowire this KafkaTemplate bean, and use it to send messages.
    @Bean
    public KafkaTemplate<String, Object> myKafkaTemplate(
            ProducerFactory<String, Object> f) {

        return new KafkaTemplate<>(f);
    }


    // Create/configure a ConsumerFactory bean that tells Kafka knows how to:
    // - deserialize message keys from Strings
    // - deserialize message values from JSON
    @Bean
    public ConsumerFactory<String, Object> myConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "group1");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(props);
    }


    // Tell Kafka about our ConsumerFactory, so Kafka can create listeners and deserialize messages.
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> myKafkaListenerContainerFactory(
            ConsumerFactory<String, Object> f) {

        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(f);
        return factory;
    }
}