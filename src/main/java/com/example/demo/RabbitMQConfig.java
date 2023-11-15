package com.example.demo;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {



    @Bean
    public Queue jsonCola() {
        return new Queue("json_cola");
    }

    @Bean
    public Binding jsonRouting() {
        return BindingBuilder
                .bind(jsonCola())
                .to(new TopicExchange("banco"))
                .with("transacciones");
    }
    @Bean
    public MessageConverter convertidor() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(convertidor());
        return rabbitTemplate;

    }
}
