package com.example.domain.rabbitmq;

import com.example.domain.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmployeeDeletedEventListener {
    private final EmployeeRepository employeeRepository;

    @RabbitListener(queues = "employeeDeleted")
    public void listen(String message) {
        System.out.println(message);
        employeeRepository.deleteById(Long.getLong(message));
    }
}