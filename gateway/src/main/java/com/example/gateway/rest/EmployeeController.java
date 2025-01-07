package com.example.gateway.rest;

import com.example.gateway.redis.RedisOperations;
import com.example.gateway.rest.dto.EmployeeDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import employee.EmployeeOuterClass;
import employee.EmployeeServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {
    @Value("${grpc.server.host}")
    private String grpcHost;

    @Value("${grpc.server.port}")
    private int grpcPort;

    public static final String REDIS_KEY_EMPLOYEES_ALL = "employees::all";

    private ManagedChannel channel;
    private EmployeeServiceGrpc.EmployeeServiceBlockingStub stub;

    private final ObjectMapper objectMapper;
    private final RabbitTemplate rabbitTemplate;
    private final RedisOperations<EmployeeDto> redisOperations;

    @PostConstruct
    private void init() {
        this.channel = ManagedChannelBuilder.forAddress(grpcHost, grpcPort)
                .usePlaintext()
                .build();
        this.stub = EmployeeServiceGrpc.newBlockingStub(channel);
    }

    @GetMapping("/employee/all")
    public List<EmployeeDto> getAllEmployees() {
        log.info("GET request for all employees");
        List<EmployeeDto> employees;
        List<EmployeeDto> cachedEmployees = redisOperations.get(REDIS_KEY_EMPLOYEES_ALL);

        if (cachedEmployees.isEmpty()) {
            EmployeeOuterClass.Empty request = EmployeeOuterClass.Empty.newBuilder().build();
            employees = stub.getAllEmployees(request).getEmployeesList().stream()
                    .map(this::toDto)
                    .collect(Collectors.toList());
            redisOperations.save(REDIS_KEY_EMPLOYEES_ALL, employees);
        } else {
            return cachedEmployees;
        }

        return employees;
    }

    @GetMapping("/employee/{id}")
    public EmployeeDto getEmployee(@PathVariable Long id) {
        log.info("GET request for employee with ID: {}", id);
        EmployeeOuterClass.EmployeeRequest request = EmployeeOuterClass.EmployeeRequest.newBuilder()
                .setId(id)
                .build();
        return toDto(stub.getEmployeeById(request));
    }

    @PostMapping("/employee/new")
    public void createEmployee(@RequestBody EmployeeDto employeeDto) {
        log.info("POST request to create employee: {}", employeeDto);
        try {
            String employeeJson = objectMapper.writeValueAsString(employeeDto);
            rabbitTemplate.convertAndSend("employeeCreated", employeeJson);
            redisOperations.delete(REDIS_KEY_EMPLOYEES_ALL);
        } catch (JsonProcessingException e) {
            log.error("Error serializing employee data", e);
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/employee/update")
    public void updateEmployee(@RequestBody EmployeeDto employeeDto) {
        log.info("PUT request to update employee: {}", employeeDto);
        try {
            String employeeJson = objectMapper.writeValueAsString(employeeDto);
            rabbitTemplate.convertAndSend("employeeUpdated", employeeJson);
            redisOperations.delete(REDIS_KEY_EMPLOYEES_ALL);
        } catch (JsonProcessingException e) {
            log.error("Error serializing employee data", e);
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        log.info("DELETE request to delete employee with ID: {}", id);
        rabbitTemplate.convertAndSend("employeeDeleted", id);
        redisOperations.delete(REDIS_KEY_EMPLOYEES_ALL);
    }

    private EmployeeDto toDto(EmployeeOuterClass.Employee employee) {
        return new EmployeeDto()
                .setId(employee.getId())
                .setName(employee.getName())
                .setPosition(employee.getPosition())
                .setSalary(employee.getSalary())
                .setHireDate(employee.getHireDate());
    }
}
