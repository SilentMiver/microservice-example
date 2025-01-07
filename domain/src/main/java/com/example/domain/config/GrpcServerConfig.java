package com.example.domain.config;

import com.example.domain.grpc.EmployeeGrpcService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcServerConfig {
    @Value("${grpc.server.port}")
    private int grpcPort;

    @Bean
    public Server grpcServer(EmployeeGrpcService employeeGrpcService) {
        return ServerBuilder.forPort(grpcPort)
                .addService(employeeGrpcService)
                .build();
    }
}