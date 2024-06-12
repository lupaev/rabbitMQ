package com.evraz.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${rabbitmq.queue.name.car.loaded}")
    private String queueForLoadedCar;

    @Value("${rabbitmq.queue.name.car.not.loaded}")
    private String queueForNotLoadedCar;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key.cl}")
    private String routingKeyForCarLoaded;

    @Value("${rabbitmq.routing.key.cnl}")
    private String routingKeyForCarNotLoaded;

    @Bean
    public Queue queueForLoadedCar() {
        return new Queue(queueForLoadedCar, false);
    }

    @Bean
    public Queue queueForNotLoadedCar() {
        return new Queue(queueForNotLoadedCar, false);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchange, false, false);
    }

    @Bean
    public Binding bindingForLoadedCar() {
        return BindingBuilder.bind(queueForLoadedCar()).to(exchange()).with(routingKeyForCarLoaded);
    }

    @Bean
    public Binding bindingForNotLoadedCar() {
        return BindingBuilder.bind(queueForNotLoadedCar()).to(exchange()).with(routingKeyForCarNotLoaded);
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
