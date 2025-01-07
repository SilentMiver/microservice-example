package com.example.domain.grpc;

import com.example.domain.domain.Employee;
import com.example.domain.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import employee.EmployeeOuterClass;
import employee.EmployeeServiceGrpc;
import io.grpc.stub.StreamObserver;

@Component
@RequiredArgsConstructor
public class EmployeeGrpcService extends EmployeeServiceGrpc.EmployeeServiceImplBase {
    private final EmployeeRepository employeeRepository;

    @Override
    public void getAllEmployees(EmployeeOuterClass.Empty request, StreamObserver<EmployeeOuterClass.EmployeeList> responseObserver) {
        var employees = employeeRepository.findAll().stream()
                .map(this::map)
                .toList();

        EmployeeOuterClass.EmployeeList employeeList = EmployeeOuterClass.EmployeeList.newBuilder()
                .addAllEmployees(employees)
                .build();

        responseObserver.onNext(employeeList);
        responseObserver.onCompleted();
    }

    @Override
    public void getEmployeeById(EmployeeOuterClass.EmployeeRequest request, StreamObserver<EmployeeOuterClass.Employee> responseObserver) {
        var employee = employeeRepository.findById(request.getId())
                .map(this::map)
                .orElse(EmployeeOuterClass.Employee.newBuilder().build()); // Если сотрудник не найден, возвращаем пустой объект.

        responseObserver.onNext(employee);
        responseObserver.onCompleted();
    }

    private EmployeeOuterClass.Employee map(Employee employee) {
        return EmployeeOuterClass.Employee.newBuilder()
                .setId(employee.getId() != null ? employee.getId() : 0) // id - long, поэтому 0 по умолчанию.
                .setName(employee.getName() != null ? employee.getName() : "")
                .setPosition(employee.getPosition() != null ? employee.getPosition() : "")
                .setSalary(employee.getSalary()) // зарплата - int, поэтому 0 по умолчанию.
                .setHireDate(employee.getHireDate() != null ? employee.getHireDate().toString() : "") // hireDate как строка.
                .build();
    }
}
