package com.example.domain.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitMQConfig {
    @Value("${rabbitmq.queues.employee-created}")
    private String employeeCreatedQueueName;
    @Value("${rabbitmq.queues.employee-updated}")
    private String employeeUpdatedQueueName;
    @Value("${rabbitmq.queues.employee-deleted}")
    private String employeeDeletedQueueName;

    @Bean
    public Queue employeeCreatedQueue() {
        return new Queue(employeeCreatedQueueName, false);
    }

    @Bean
    public Queue employeeUpdatedQueue() {
        return new Queue(employeeUpdatedQueueName, false);
    }

    @Bean
    public Queue employeeDeletedQueue() {
        return new Queue(employeeDeletedQueueName, false);
    }
}