package com.example.domain.rabbitmq;

import com.example.domain.domain.Employee;
import com.example.domain.repository.EmployeeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmployeeCreatedEventListener {
    private final ObjectMapper objectMapper;
    private final EmployeeRepository employeeRepository;

    @RabbitListener(queues = "employeeCreated")
    public void listen(String message) {
        Employee employee;
        try {
            System.out.println(message);
            employee = objectMapper.readValue(message, Employee.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        employeeRepository.save(employee);
    }
}