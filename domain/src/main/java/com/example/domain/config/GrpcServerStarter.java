package com.example.domain.config;

import com.example.domain.domain.Employee;
import com.example.domain.repository.EmployeeRepository;

import io.grpc.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class GrpcServerStarter implements CommandLineRunner {
    private final Server grpcServer;
    private final EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        var employee = new Employee()
                .setName("John Doe")
                .setPosition("Manager")
                .setSalary(50000)
                .setHireDate(LocalDate.of(2020, 1, 15));
        employeeRepository.save(employee);

        grpcServer.start();
        grpcServer.awaitTermination();
    }
}