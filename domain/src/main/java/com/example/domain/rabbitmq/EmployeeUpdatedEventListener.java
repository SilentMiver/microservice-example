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
public class EmployeeUpdatedEventListener {
    private final ObjectMapper objectMapper;
    private final EmployeeRepository employeeRepository;

    @RabbitListener(queues = "employeeUpdated")
    public void listen(String message) {
        Employee employee;
        try {
            System.out.println(message);
            employee = objectMapper.readValue(message, Employee.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        var updatingEmployee = employeeRepository.findById(employee.getId())
                .orElse(new Employee());
        if (employee.getName() != null && !employee.getName().isEmpty()) updatingEmployee.setName(employee.getName());
        if (employee.getPosition() != null && !employee.getPosition().isEmpty()) updatingEmployee.setPosition(employee.getPosition());

        if (employee.getHireDate() != null) updatingEmployee.setHireDate(employee.getHireDate());
        employeeRepository.save(updatingEmployee);
    }
}