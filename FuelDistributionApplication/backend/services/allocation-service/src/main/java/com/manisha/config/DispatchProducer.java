package com.manisha.config;

import com.google.gson.Gson;
import com.manisha.event.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DispatchProducer {

    Logger logger = LoggerFactory.getLogger(Producer.class);
    public static final String topic = "NewAttachment";
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void publish(Event message) {
        logger.info("Publish dispatch from order " + topic);
        Gson gson=new Gson();
        String newMessage=gson.toJson(message);
        this.kafkaTemplate.send(topic, newMessage);

    }
}
