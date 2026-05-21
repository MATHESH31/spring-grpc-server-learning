package com.learning.grpc.service;

import com.learning.grpc.Employee;
import com.learning.grpc.store.EmployeeStore;
import employee.v1.EmployeeOuterClass;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeStore employeeStore;

    public EmployeeService(EmployeeStore employeeStore) {
        this.employeeStore = employeeStore;
    }

    public EmployeeOuterClass.EmployeeResponse getEmployee(int id) {
        employeeStore.loadEmployees();
        Employee employee = employeeStore.getEmployee(id);
        EmployeeOuterClass.EmployeeResponse response = EmployeeOuterClass.EmployeeResponse.newBuilder()
                .setId(employee.id())
                .setName(employee.name())
                .setAge(employee.age())
                .setSalary(employee.salary())
                .build();
        return response;
    }
}
