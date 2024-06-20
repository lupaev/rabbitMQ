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

    //direct
    @Value("${rabbitmq.queue.name.car.loaded}")
    private String queueForLoadedCar;

    @Value("${rabbitmq.queue.name.car.not.loaded}")
    private String queueForNotLoadedCar;

    @Value("${rabbitmq.direct.exchange.name}")
    private String directExchangeName;

    @Value("${rabbitmq.routing.key.cl}")
    private String routingKeyForCarLoaded;

    @Value("${rabbitmq.routing.key.cnl}")
    private String routingKeyForCarNotLoaded;

    //fanout
    @Value("${rabbitmq.fanout.exchange.name}")
    private String fanoutExchangeName;

    @Value("${rabbitmq.queue.name.car.factory.one}")
    private String queueForFactoryOne;

    @Value("${rabbitmq.queue.name.car.factory.two}")
    private String queueForFactoryTwo;

    //topic
    @Value("${rabbitmq.topic.exchange.name}")
    private String topicExchangeName;

    @Value("${rabbitmq.queue.name.car.topic}")
    private String queueForCar;

    @Value("${rabbitmq.routing.key}")
    private String routingKeyForLoadedCar;

    //headers
    @Value("${rabbitmq.header.exchange.name}")
    private String headerExchangeName;

    @Value("${rabbitmq.queue.name.car.header}")
    private String queueForCarHeader;



    //Queue
    @Bean
    public Queue queueForLoadedCar() {
        return new Queue(queueForLoadedCar, true);
    }

    @Bean
    public Queue queueForNotLoadedCar() {
        return new Queue(queueForNotLoadedCar, true);
    }

    @Bean
    public Queue queueForFactoryOne() {
        return new Queue(queueForFactoryOne, true);
    }

    @Bean
    public Queue queueForFactoryTwo() {
        return new Queue(queueForFactoryTwo, true);
    }

    @Bean
    public Queue queueCar() {
        return new Queue(queueForCar, true);
    }

    @Bean
    public Queue queueCarHeader() {
        return new Queue(queueForCarHeader, true);
    }


    //Exchange
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(directExchangeName, true, false);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(fanoutExchangeName, true, false);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(topicExchangeName, true, false);
    }

    @Bean
    public HeadersExchange headersExchange() {
        return new HeadersExchange(headerExchangeName, true, false);
    }

    //Binding
    @Bean
    public Binding bindingForFactoryOne() {
        return BindingBuilder.bind(queueForFactoryOne()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingForFactoryTwo() {
        return BindingBuilder.bind(queueForFactoryTwo()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingForLoadedCar() {
        return BindingBuilder.bind(queueForLoadedCar()).to(directExchange()).with(routingKeyForCarLoaded);
    }

    @Bean
    public Binding bindingForNotLoadedCar() {
        return BindingBuilder.bind(queueForNotLoadedCar()).to(directExchange()).with(routingKeyForCarNotLoaded);
    }

    @Bean
    public Binding bindingForCar() {
        return BindingBuilder.bind(queueCar()).to(topicExchange()).with(routingKeyForLoadedCar);
    }

    @Bean
    public Binding bindingForCarHeader() {
        return BindingBuilder.bind(queueCarHeader()).to(headersExchange()).where("isLoad").matches("1");
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
