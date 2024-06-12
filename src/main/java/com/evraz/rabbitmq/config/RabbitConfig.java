package com.evraz.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${queue.for.loaded.car}")
    private String queueForLoadedCar;

    @Value("${queue.for.not.loaded.car}")
    private String queueForNotLoadedCar;

    @Value("${queue.exchange}")
    private String carExchange;

    @Value("${routing.key.cl}")
    private String routingKeyForCarLoaded;

    @Value("${routing.key.cnl}")
    private String routingKeyForCarNotLoaded;

//    @Bean
//    public Queue queueForLoadedCar() {
//        return new Queue(queueForLoadedCar, false);
//    }
//
//    @Bean
//    public Queue queueForNotLoadedCar() {
//        return new Queue(queueForNotLoadedCar, false);
//    }

    @Bean
    public Queue queue() {
        return new Queue("queue", false);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("car", false, false);
    }

    @Bean
    public Binding bindingForLoadedCar() {
        return BindingBuilder.bind(queue()).to(exchange()).with("car.loaded");
    }

    @Bean
    public Binding bindingForNotLoadedCar() {
        return BindingBuilder.bind(queue()).to(exchange()).with("car.not.loaded");
    }


    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }

}
